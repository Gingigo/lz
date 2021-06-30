package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Leexiaobu
 * @date 2020-08-25 11:10:37
 */
public class LruCache<K, V> {
    private final LinkedHashMap<K, V> map;
    private int size;
    private int maxSize;
    private int hitCount;
    private int missCount;
    private int createCount;
    private int evictionCount;
    int putCount;

    protected void entryEvicted(K key, V value) {}

    public LruCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException(String.format("Error Argument %s !", maxSize));
        }
        this.maxSize = maxSize;
        map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    public  V get(K key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        V result = map.get(key);
        if (result != null) {
            hitCount++;
            return result;
        }
        missCount++;
        // TODO: release the lock while calling this potentially slow user code
         result = create(key);
        if (result != null) {
            createCount++;
            size += safeSizeOf(key, result);
            map.put(key, result);
            trimToSize(maxSize);
        }
        return result;
    }

    public V put(K key,V value){
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        putCount++;
        size += safeSizeOf(key, value);
        V pre = map.put(key, value);
        if(pre!=null){
            size-=safeSizeOf(key,value);
        }
        trimToSize(maxSize);
        return pre;
    }

    private void trimToSize(int maxSize) {
        while (size>maxSize&&!map.isEmpty()){
            Map.Entry<K, V> next = map.entrySet().iterator().next();
            if(next==null){
                break;
            }
            K key = next.getKey();
            V value = next.getValue();
            map.remove(key);
            size-=safeSizeOf(key,value);
            evictionCount++;
            entryEvicted(key, value);
        }
        if (size < 0 || (map.isEmpty() && size != 0)) {
            throw new IllegalStateException(getClass().getName()
                    + ".sizeOf() is reporting inconsistent results!");
        }
    }

    /**
     * Called after a cache miss to compute a value for the corresponding key.
     * Returns the computed value or null if no value can be computed. The
     * default implementation returns null.
     */
    protected V create(K key) {
        return null;
    }
    /**
     * Removes the entry for {@code key} if it exists.
     *
     * @return the previous value mapped by {@code key}. Although that entry is
     *     no longer cached, it has not been passed to {@link #entryEvicted}.
     */
    public synchronized final V remove(K key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        V previous = map.remove(key);
        if (previous != null) {
            size -= safeSizeOf(key, previous);
        }
        return previous;
    }
    private int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return result;
    }
    /**
     * Returns the size of the entry for {@code key} and {@code value} in
     * user-defined units.  The default implementation returns 1 so that size
     * is the number of entries and max size is the maximum number of entries.
     *
     * <p>An entry's size must not change while it is in the cache.
     */
    protected int sizeOf(K key, V value) {
        return 1;
    }


    /**
     * Clear the cache, calling {@link #entryEvicted} on each removed entry.
     */
    public synchronized final void evictAll() {
        trimToSize(-1); // -1 will evict 0-sized elements
    }
    /**
     * For caches that do not override {@link #sizeOf}, this returns the number
     * of entries in the cache. For all other caches, this returns the sum of
     * the sizes of the entries in this cache.
     */
    public synchronized final int size() {
        return size;
    }
    /**
     * For caches that do not override {@link #sizeOf}, this returns the maximum
     * number of entries in the cache. For all other caches, this returns the
     * maximum sum of the sizes of the entries in this cache.
     */
    public synchronized final int maxSize() {
        return maxSize;
    }
    /**
     * Returns the number of times {@link #get} returned a value.
     */
    public synchronized final int hitCount() {
        return hitCount;
    }
    /**
     * Returns the number of times {@link #get} returned null or required a new
     * value to be created.
     */
    public synchronized final int missCount() {
        return missCount;
    }
    /**
     * Returns the number of times {@link #create(Object)} returned a value.
     */
    public synchronized final int createCount() {
        return createCount;
    }
    /**
     * Returns the number of times {@link #put} was called.
     */
    public synchronized final int putCount() {
        return putCount;
    }
    /**
     * Returns the number of values that have been evicted.
     */
    public synchronized final int evictionCount() {
        return evictionCount;
    }
    /**
     * Returns a copy of the current contents of the cache, ordered from least
     * recently accessed to most recently accessed.
     */
    public synchronized final Map<K, V> snapshot() {
        return new LinkedHashMap<K, V>(map);
    }
    @Override public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
    }
}
