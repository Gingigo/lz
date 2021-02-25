package leetcode.leetcode.editor.cn;
//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 

//leetcode submit region begin(Prohibit modification and deletion)
class _34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] ints = {2,2};
        int[] ints1 = new _34_FindFirstAndLastPositionOfElementInSortedArray().searchRange(ints, 3);

        for (int value : ints1) {
            System.out.print(value);
        }

    }
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int left=left_bound(nums,target);
        int right= right_bound(nums,target);
        return new int[]{left,right};
    }



    int binary_search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }
    int right_bound(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid =left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target) {
//                这个地方如何处理
                left=mid+1;
            }
        }
        if(right<0||nums[right]!=target){
            return -1;
        }

        return right;
    }


    int left_bound(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid =left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid] ==target){
                right=mid-1;
            }
        }
        if(left>nums.length-1||nums[left]!=target){
            return -1;
        }
        return left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

