package leetcode.leetcode.editor.cn;
//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics

import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class _215_KthLargestElementInAnArray {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

