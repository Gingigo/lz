package leetcode.leetcode.editor.cn;
//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// Example: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. 
// Related Topics 数组 双指针 二分查找

import java.util.HashMap;
import java.util.Map;


//leetcode submit region begin(Prohibit modification and deletion)
class _167_TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int[] ints1 = new _167_TwoSumIiInputArrayIsSorted().twoSum2(ints, 9);
        System.out.println(ints1);

    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int minNumber = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            } else if (numbers[i] + minNumber > target) {
                return new int[]{};
            }
            map.put(numbers[i], i + 1);
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right && left >= 0 && right < numbers.length) {
            int sum = numbers[left] + numbers[right];
            if (numbers[left] + numbers[right] < target) {
                left = left + 1;
            } else if (sum > target) {
                right = right - 1;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }


}
//leetcode submit region end(Prohibit modification and deletion)

