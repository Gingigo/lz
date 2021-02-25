package leetcode.leetcode.editor.cn;
//Given a sorted (in ascending order) integer array nums of n elements and a tar
//get value, write a function to search target in nums. If target exists, then ret
//urn its index, otherwise return -1. 
//
// 
//Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
//
// Note: 
//
// 
// You may assume that all elements in nums are unique. 
// n will be in the range [1, 10000]. 
// The value of each element in nums will be in the range [-9999, 9999]. 
// 
// Related Topics 二分查找

//leetcode submit region begin(Prohibit modification and deletion)
class _704_BinarySearch {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left =0;
        int right=nums.length-1;
        while (left<=right){
            int mid =left+(right-left)/2;
            int num = nums[mid];
            if(num<target){
                left=mid+1;
            }else if(num>target){
                right=mid-1;
            }else if(num==target){
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

