package leetcode.leetcode.editor.cn;
//Given an array nums containing n + 1 integers where each integer is between 1 
//and n (inclusive), prove that at least one duplicate number must exist. Assume t
//hat there is only one duplicate number, find the duplicate one. 
//
// Example 1: 
//
// 
//Input: [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [3,1,3,4,2]
//Output: 3 
//
// Note: 
//
// 
// You must not modify the array (assume the array is read only). 
// You must use only constant, O(1) extra space. 
// Your runtime complexity should be less than O(n2). 
// There is only one duplicate number in the array, but it could be repeated mor
//e than once. 
// 
// Related Topics 数组 双指针 二分查找

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class _287_FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] ints = {1, 8, 9, 2, 2, 3, 5, 6, 7,4};
        int duplicate = new _287_FindTheDuplicateNumber().findDuplicate(ints);
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        if (nums.length <= 2) return nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }


    public int findDuplicate2(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

