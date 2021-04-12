package leetcode.leetcode.editor.cn;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1134 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//_78_Subsets
//leetcode submit region begin(Prohibit modification and deletion)
class _78_Subsets {

    public static void main(String[] args) {

    }
    //回溯算法问题
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    void backtrack(List<List<Integer>> ans,List <Integer> tempList,int [] nums,int index){
        //这里可以考虑加不加进结果
        ans.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            //这里是当前值放进 tempList
            tempList.add(nums[i]);
            backtrack(ans,tempList,nums,i+1);
            //这里是当前值不放进tempList,这种情况在上一层就考虑到了
            tempList.remove(tempList.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
