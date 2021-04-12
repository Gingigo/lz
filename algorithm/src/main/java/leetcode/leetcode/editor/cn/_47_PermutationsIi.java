package leetcode.leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 668 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//_47_PermutationsIi
//leetcode submit region begin(Prohibit modification and deletion)
class _47_PermutationsIi {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,new boolean[nums.length]);
        return list;
    }

    void backtrack(List<List<Integer>> ans,List <Integer> tempList,int [] nums,boolean [] used){
        //这里可以考虑加不加进结果
        if(tempList.size()==nums.length){
            ans.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]||i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            //这里是当前值放进 tempList
            tempList.add(nums[i]);
            used[i]=true;
            backtrack(ans,tempList,nums,used);
            //这里是当前值不放进tempList,这种情况在上一层就考虑到了
            tempList.remove(tempList.size()-1);
            used[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
