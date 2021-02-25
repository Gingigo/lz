package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        int i = minPathSum(new int[][]{{1, 2}, {1, 1}});
        System.out.println(i);
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length ][grid[0].length ];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = grid[0][0];
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length -1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 694 👎 0

