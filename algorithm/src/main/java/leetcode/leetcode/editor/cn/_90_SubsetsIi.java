package leetcode.leetcode.editor.cn;//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 559 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//_90_SubsetsIi
//leetcode submit region begin(Prohibit modification and deletion)
class _90_SubsetsIi {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans,new ArrayList<Integer>(),nums,0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> tempList, int[] nums, int index) {
        ans.add(new ArrayList<>(tempList));
        for (int j = index; j < nums.length; j++) {
            if(j>index&&nums[j]==nums[j-1]){
                continue;
            }
            tempList.add(nums[j]);
            backtrack(ans,tempList,nums,j+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
