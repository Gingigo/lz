package leetcode.leetcode.editor.cn;
// ToDo-Lee


//leetcode submit region begin(Prohibit modification and deletion)
class _392_IsSubsequence {
    public static void main(String[] args) {
        boolean subsequence = isSubsequence("abc"
                , "ahbgdc");
    }
    public static boolean isSubsequence(String s, String t) {
        int sleft=0;
        int sright=s.length()-1;
        int tleft=0;
        int tright=t.length()-1;
        while(sleft<=sright&&tleft<tright){
            if(t.charAt(tleft)==s.charAt(sleft)){
                tleft++;
                sleft++;
            }else{
                tleft++;
            }
            if(t.charAt(tright)==s.charAt(sright)){
                tright--;
                sright--;
            }else{
                tright--;
            }
        }
        if(sleft>sright){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 340 👎 0

