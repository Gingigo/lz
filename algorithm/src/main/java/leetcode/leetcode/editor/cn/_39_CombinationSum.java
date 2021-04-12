package leetcode.leetcode.editor.cn;
// ToDo-Lee

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class _39_CombinationSum {
    public static void main(String[] args) {
        _39_CombinationSum combinationSum = new _39_CombinationSum();
        int[] candidates = {2, 3, 5};
        int target = 7;
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).forEach(System.out::print);
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(),candidates, target,0);
        return list;
    }

    void backtrack(List<List<Integer>> ans,List <Integer> tempList,int [] nums,int target,int index){
        if(target==0){
            ans.add(new ArrayList<>(tempList));
         }else {
            for (int i = index; i < nums.length; i++) {
                if (target - nums[i] < 0) {
                    break;
                }
                //这里是当前值放进 tempList
                tempList.add(nums[i]);
                backtrack(ans,tempList,nums,target-nums[i],i);
                //这里是当前值不放进tempList,这种情况在上一层就考虑到了
                tempList.remove(tempList.size()-1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 866 👎 0

