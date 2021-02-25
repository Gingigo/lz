package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class _16_ThreeSumClosest {
    public static void main(String[] args) {
        int[] a = {-1,2,1,-4};
        int i = new _16_ThreeSumClosest().threeSumClosest(a, 1);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = 13000;
        boolean flag = true;
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp > target) {
                    if (temp - target < result) {
                        result = temp - target;
                        flag = true;
                    }
                    right--;
                } else if (temp < target) {
                    if (target - temp < result) {
                        result = target - temp;
                        flag = false;
                    }
                    left++;
                } else {
                    return target;
                }
            }
        }
        return flag ? (target + result) : (target - result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
// 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 559 👎 0

