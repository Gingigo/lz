package leetcode.leetcode.editor.cn;
// ToDo-Lee

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class _350_IntersectionOfTwoArraysIi {
    public static void main(String[] args) {

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                int temp = map.get(nums2[i]) - 1;
                if (temp == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], temp);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    //What if the given array is already sorted? How would you optimize your algori
    public int[] intersectPro(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9] 
// 
//
// Note: 
//
// 
// Each element in the result should appear as many times as it shows in both ar
//rays. 
// The result can be in any order. 
// 
//
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your algori
//thm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is be
//tter? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 378 👎 0

