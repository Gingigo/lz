package leetcode.leetcode.editor.cn;
// ToDo-Lee

//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//leetcode submit region begin(Prohibit modification and deletion)
class _4_MedianOfTwoSortedArrays {
//NOTE 困难
//   
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int tempI = 0;
        int tempJ = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                result[i + j] = nums1[i];
                i++;
                tempI = i;
            } else {
                result[i + j] = nums2[j];
                j++;
                tempJ = j;
            }
        }
        if (tempI == nums1.length) {
            for (int j = tempJ; j < nums2.length; j++) {
                result[tempI + j] = nums2[j];
            }
        } else  if(tempJ == nums2.length) {
            for (int i = tempI; i < nums1.length; i++) {
                result[tempJ + i] = nums1[i];
            }
        }

        if (result.length % 2 == 0) {

            return (result[result.length / 2 - 1] + result[result.length / 2]) / 2.0;
        } else {

            return result[result.length / 2] / 1.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3124 👎 0

