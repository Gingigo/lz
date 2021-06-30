package leetcode.leetcode.editor.cn;
//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics 数组 哈希表

import java.util.HashMap;
import java.util.Map;

// 复习过
//leetcode submit region begin(Prohibit modification and deletion)
class _1_TwoSum {

  public static void main(String[] args) {
  }

  /*NOTE 哈希表*/
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      } else {
        map.put(nums[i], i);
      }

    }
    return new int[]{};
  }

}
//leetcode submit region end(Prohibit modification and deletion)

