package leetcode.leetcode.editor.cn;//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1286 👎 0

import java.util.ArrayList;
import java.util.List;

//_46_Permutations
//leetcode submit region begin(Prohibit modification and deletion)
class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums);
        return list;
    }

    void backtrack(List<List<Integer>> ans,List <Integer> tempList,int [] nums){
        if(tempList.size()==nums.length){
            ans.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            //这里是当前值放进 tempList
            if(tempList.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(ans,tempList,nums);
            //这里是当前值不放进tempList,这种情况在上一层就考虑到了
            tempList.remove(tempList.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
