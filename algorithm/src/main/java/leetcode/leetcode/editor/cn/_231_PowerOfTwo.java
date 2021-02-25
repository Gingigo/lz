package leetcode.leetcode.editor.cn;
// ToDo-Lee

//leetcode submit region begin(Prohibit modification and deletion)
class _231_PowerOfTwo {
    public static void main(String[] args) {
        _231_PowerOfTwo powerOfTwo_231 = new _231_PowerOfTwo();
        for (int i = 0; i < 500; i++) {
            boolean powerOfTwo = powerOfTwo_231.isPowerOfTwo(i);
            System.out.println(powerOfTwo + ":" + i);
        }

    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        int num = 0;
        while (n >= 2 && num == 0) {
            num = n % 2;
            n = n / 2;
        }
        return num == 0;
    }

    public boolean isPowerOfTwoPlus(int n) {
        if (n <= 0) {
            return false;
        }
        //100 & 011=000
        return (n & (n - 1)) == 0;
    }
    public boolean isPowerOfTwoPlus2(int n) {
        if (n <= 0) {
            return false;
        }
        //取模
        return (1<<30) % n == 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 237 👎 0

