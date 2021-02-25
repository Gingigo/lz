package algorithm;


/**
 * @author Leexiaobu
 * @date 2020-09-07 14:53:28
 */
public class KMP {
    //"aabaaabaaac"
//"aabaaac"
//    "mississippi"
//"pi"
    public static void main(String[] args) {
        String key = "pi";
        String target = "mississippi";
        int[] kArray = new KMP().getKArray(key);
        System.out.println(target);
        System.out.println(key);
        for (int i = 0; i < kArray.length; i++) {
            System.out.print(kArray[i]);
        }
        System.out.println();
        int compare = new KMP().compare(target, key);
        System.out.println("ans :" + compare);
    }

    /**
     * @description 获取KSingle 数组
     * @author Leexiaobu 2020/09/07 15:53:45
     * @version 1.0
     */
    private int[] getKArray(String key) {
        int[] array = new int[key.length()];
        array[0] = 0;
        // 从1开始，array 当前值 和array前一个值相关。
        for (int i = 1; i < array.length; i++) {
            int temp = array[i - 1];
            if (key.charAt(temp) == key.charAt(i)) {
                array[i] = temp + 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }
    int compare(String target, String key) {
        int ans = -1;
        if ("".equals(key)) {
            return 0;
        }

        int[] kArray = getKArray(key);
        int current = 0;
        for (int i = 0; i < target.length(); ) {
            if (target.charAt(i) == key.charAt(current)) {
                if (current == key.length() - 1) {
                    return i - kArray.length + 1;
                }
                current++;
                i++;
            } else {
                /*这里回溯，找到数组里最后一个不为0的数，然后在匹配*/
                while (current>0&&kArray[current - 1] == 0){
                    current--;
                    i--;
                }
                if (current == 0) {
                    i++;
                } else {
                   current = kArray[current - 1];
                }
            }

        }
        return ans;
    }
}
