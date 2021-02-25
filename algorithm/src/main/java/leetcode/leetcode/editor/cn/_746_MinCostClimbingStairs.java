package leetcode.leetcode.editor.cn;
// ToDo-Lee


//leetcode submit region begin(Prohibit modification and deletion)
class _746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] ints = {0, 1, 1, 0};
        int i = new _746_MinCostClimbingStairs().minCostClimbingStairs(ints);
        System.out.println(i);
    }
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }

        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2])+cost[i];
        }
        return Math.min(cost[cost.length - 1],cost[cost.length-2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。 
//
// 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。 
//
// 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。 
//
// 示例 1: 
//
// 输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
// 
//
// 示例 2: 
//
// 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出: 6
//解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
// 
//
// 注意： 
//
// 
// cost 的长度将会在 [2, 1000]。 
// 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。 
// 
// Related Topics 数组 动态规划 
// 👍 360 👎 0

