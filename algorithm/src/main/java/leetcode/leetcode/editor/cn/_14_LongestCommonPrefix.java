package leetcode.leetcode.editor.cn;
// ToDo-Lee


//leetcode submit region begin(Prohibit modification and deletion)
class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"fight", "fish", "fire"};
        String s = new _14_LongestCommonPrefix().longestCommonPrefix(strings);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; flag; i++) {
            Character chartemp = null;
            for (int j = 0; j < length; j++) {
                if (!(i < strs[j].length())) {
                    flag = false;
                    break;
                }
                if (chartemp == null) {
                    chartemp = strs[j].charAt(i);
                } else if (chartemp == strs[j].charAt(i)) {
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append(chartemp);
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1234 👎 0

