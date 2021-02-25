package leetcode.leetcode.editor.cn;
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics 栈 字符串

import java.util.HashMap;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class _20_ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if ((s.length() % 2 == 1)) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if ((!(!stack.isEmpty() && (stack.pop().equals(map.get(c)))))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean valid = new _20_ValidParentheses().isValid("{[]}");
        System.out.println(valid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

