package leetcode.leetcode.editor.cn;
//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics 数组 二分查找

//leetcode submit region begin(Prohibit modification and deletion)
class _74_SearchA2dMatrix {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int[] matrixChild = matrix[i];
            if (matrixChild.length == 0) {
                continue;
            }
            if (matrixChild[matrixChild.length - 1] == target) {
                return true;
            } else if (matrixChild[matrixChild.length - 1] < target) {
                continue;
            } else {
                for (int i1 = matrixChild.length - 2; i1 >= 0; i1--) {
                    if (matrixChild[i1] < target) {
                        return false;
                    } else if (matrixChild[i1] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int j = mid / n;
            int i = mid % n;
            if (matrix[j][i] == target) {
                return true;
            } else if (matrix[j][i] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

