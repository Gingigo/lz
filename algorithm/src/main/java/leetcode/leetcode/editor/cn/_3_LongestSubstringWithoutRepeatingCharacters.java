package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class _3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }


    /*NOTE 无重复字符最长子串
     *   窗口 重点是判断存在后 remove 窗口开始 而不是当前的
     *  */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        // 核心，左边依次向前进
        int rc = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
        // NOTE  重点
            while (set.contains(temp)) {
                set.remove(s.charAt(rc));
                rc++;
            }
            set.add(temp);
            ans = Math.max(ans, set.size());
//            if (set.contains(temp)) {
//                //注意点
//                while (set.contains(temp)) {
//                    set.remove(s.charAt(rc));
//                    rc++;
//                }
//                set.add(temp);
//            } else {
//                set.add(temp);
//                ans = Math.max(ans, set.size());
//            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4280 👎 0

