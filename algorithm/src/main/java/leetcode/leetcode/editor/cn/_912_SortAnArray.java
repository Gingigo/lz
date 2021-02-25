package leetcode.leetcode.editor.cn;
// ToDo-Lee


//leetcode submit region begin(Prohibit modification and deletion)
class _912_SortAnArray {
    public static void main(String[] args) {
        int[] ints = new _912_SortAnArray().mergeSort(new int[]{5, 2, 3, 1});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    int[] mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1, new int[array.length]);
        return array;
    }

    void mergeSortHelper(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid, temp);
        mergeSortHelper(array, mid + 1, right, temp);
        mergeArrays(array, left, mid, right, temp);
    }

    void mergeArrays(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int i = 0;
        for (; left <= mid && right <= end; i++) {
            if (array[left] < array[right]) {
                temp[start + i] = array[left];
                left++;
            } else {
                temp[start + i] = array[right];
                right++;
            }
        }
        for (; left <= mid; i++) {
            temp[start + i] = array[left];
            left++;
        }
        for (; right <= end; i++) {
            temp[start + i] = array[right];
            right++;
        }
        for (int j = start; j <= end; j++) {
            array[j] = temp[j];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 165 👎 0

