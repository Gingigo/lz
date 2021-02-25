package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class _17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> list = new _17_LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        list.forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("")) {
            return list;
        }
        String[] args = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, args, sb, list, 0);
        return list;
    }

    void letterCombinationsHelper(String digits, String[] args, StringBuilder sb, List<String> list, int index) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
//        for (int i = index; i < digits.length(); i++) {
//
//        }
        String string = args[Character.getNumericValue(digits.charAt(index)) - 2];
        for (int j = 0; j < string.length(); j++) {
            sb.append(string.charAt(j));
            letterCombinationsHelper(digits, args, sb, list, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 914 👎 0

