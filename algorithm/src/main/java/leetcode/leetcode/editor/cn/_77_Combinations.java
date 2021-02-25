package leetcode.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class _77_Combinations {
    public static void main(String[] args) {
        _77_Combinations combinations = new _77_Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        for (int i = 0; i < combine.size(); i++) {
            combine.get(i).forEach(System.out::print);
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combineHelper(n, k, ans, list, 1);
        return ans;
    }

    void combineHelper(int n, int k, List<List<Integer>> ans, List<Integer> list, int index) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(index);
            combineHelper(n, k, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 383 👎 0

