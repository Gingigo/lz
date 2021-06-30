package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 需要什么？
 * 1.插入新的元素
 * 2.淘汰旧的元素
 * 3.排序
 * 4.取的速度快
 *
 * @author Leexiaobu
 * @date 2020-08-23 21:20:56
 */
public class LRUTest<K, V> extends LinkedHashMap<K, V> {
    int MAX_CACHE_SIZE;

    public LRUTest(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    public static void main(String[] args) {
        LruCache<Integer, Integer> cache = new LruCache<>(8);
        for (int i = 0; i < 10; i++) {
            cache.put(i, i);
            System.out.println(cache);
            if(i==8){
                Integer integer = cache.get(2);
                System.out.println(integer);
                cache.get(9);
            }
        }

    }

}
