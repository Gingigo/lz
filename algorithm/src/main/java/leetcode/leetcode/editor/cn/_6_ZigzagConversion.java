package leetcode.leetcode.editor.cn;
// ToDo-Lee


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class   _6_ZigzagConversion {
    public static void main(String[] args) {
        String leetcodeishiring = new _6_ZigzagConversion().convert("LEETCODEISHIRING", 3);
        System.out.println(leetcodeishiring);
    }

    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || length <= 1) {
            return s;
        }
        int singleLength = numRows * 2 - 2;
        int time = length / singleLength + 1;
        List<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < singleLength && singleLength * i + j < length; j++) {
                    int temp=j;
                if (j+1 > numRows) {
                    temp  = numRows - (j+1 - numRows)-1;
                }
                list.get(temp).append(s.charAt(i * singleLength + j));
            }

        }
        for (int i = 1; i < list.size(); i++) {
            list.get(0).append(list.get(i));
        }
        return list.get(0).toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//      2次4余 3次差3     4行 6个
//L0        D1          R2
//E3    O4  E5      I6  I7
//E8 C9     I10  H11    N12
//T13       S14         G15

//L1        D7          R13
//E2    O6  E8      I12 I14
//E3 C5     I9  H11     N15
//T4       S10          G16
// Related Topics 字符串 
// 👍 805 👎 0

