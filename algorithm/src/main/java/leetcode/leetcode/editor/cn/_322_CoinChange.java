package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class _322_CoinChange {
    public static void main(String[] args) {
        int[] ints = {1, 2, 5};
        int amount =11;
        int i = new _322_CoinChange().coinChange(ints, amount);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        for(int i=1;i<=amount;i++){
            int temp=Integer.MAX_VALUE;
            for (int i1 = 0; i1 < coins.length; i1++) {
                if(i-coins[i1]>=0&&dp[i-coins[i1]]>=0){
                    temp=Math.min(temp,dp[i-coins[i1]]+1);
                }
            }
            if(temp!=Integer.MAX_VALUE){
                dp[i]=temp;
            }else {
                dp[i]=-1;
            }
        }

        for (int i : dp) {
            System.out.println(i);
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 868 👎 0

