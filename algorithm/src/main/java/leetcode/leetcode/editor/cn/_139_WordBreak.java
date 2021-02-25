package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class _139_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
//        System.out.println(s.substring(0,1));
//        System.out.println(s.substring(1));
        boolean b = new _139_WordBreak().wordBreak(s, list);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    boolean wordHelper(String s, HashSet<String> wordDictSet, HashSet<String> errorSet) {
        boolean result = false;
        if (errorSet.contains(s)) {
            return false;
        }
        if (wordDictSet.contains(s)) {
            return true;
        } else {
            errorSet.add(s);
        }


        for (int i = 1; i < s.length(); i++) {
            result = result || (wordHelper(s.substring(0, i), wordDictSet, errorSet) && wordHelper(s.substring(i), wordDictSet, errorSet));
        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
// 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 647 👎 0

