package leetcode.leetcode.editor.cn;
// ToDo-Lee


//leetcode submit region begin(Prohibit modification and deletion)
class _136_SingleNumber {
    public static void main(String[] args) {
        int i = new _136_SingleNumber().singleNumber(new int[]{3, 3, 5});
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1463 👎 0

