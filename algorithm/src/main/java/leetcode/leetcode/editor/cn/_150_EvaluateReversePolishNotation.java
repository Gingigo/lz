package leetcode.leetcode.editor.cn;
//根据逆波兰表示法，求表达式的值。
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 示例 1： 
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: ((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: (4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
// Related Topics 栈


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//leetcode submit region begin(Prohibit modification and deletion)
class _150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
         String [] test ={"4","13","5","/","+"};
        int i = new _150_EvaluateReversePolishNotation().evalRPN(test);
        System.out.println(i);
    }
    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Integer result =0;

        for (int i = 0; i <tokens.length ; i++) {
//           默认是正常的参数
            if (set.contains(tokens[i])) {
                Integer params=stack.pop();
                result = stack.pop();
                if ("-".equals(tokens[i])) {
                    result = result - params;
                } else if ("+".equals(tokens[i])) {
                    result = result + params;
                } else if ("*".equals(tokens[i])) {
                    result = result * params;
                } else {
                    result = result / params;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

