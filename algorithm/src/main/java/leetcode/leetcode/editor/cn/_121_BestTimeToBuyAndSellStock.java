package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class _121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] ints = {7,1,5,3,6,4};
        int i = maxProfit(ints);
        System.out.println(i);
        HashMap<String,Integer> hash = new HashMap<>();
        hash.put("min",Integer.MAX_VALUE);
        hash.put("max",0);
        HashMap<String, Integer> minAndMax = getMinAndMax(ints, hash, ints.length - 1);
        System.out.println(minAndMax.get("min"));
        System.out.println(minAndMax.get("max"));
    }

    //自顶向下
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int pre = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < pre) {
                pre = prices[i];
            } else {
                max = Math.max(max, prices[i] - pre);
            }
        }
        return max;
    }

    //自底向上
    public static HashMap<String, Integer> getMinAndMax(int[] prices, HashMap<String, Integer> hashMap, int k) {
        if (k == 0) {
            hashMap.put("min",prices[0]);
            hashMap.put("max",0);
            return hashMap;
        }
        Integer min = hashMap.get("min");
        Integer max = hashMap.get("max");
        hashMap = getMinAndMax(prices, hashMap, k - 1);
        min=Math.min((hashMap.get("min")), prices[k]);
        max=Math.max(hashMap.get("max"),prices[k]-min);
        hashMap.put("min", min);
        hashMap.put("max", max);
        return hashMap;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1240 👎 0

