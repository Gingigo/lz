package leetcode.leetcode.editor.cn;
//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics 字符串 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
class _5_LongestPalindromicSubstring {
    /*NOTE 最长回文串
        1.动态规划  S(i,j)=S(i+1,j-1)&& si=sj
    *   2. 分1扩散 和2扩散 */
    public static void main(String[] args) {
        String abccba = "abaabccba";
        String s = new _5_LongestPalindromicSubstring().longestPalindrome(abccba);
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }

        String single = longSingle(s);
        String doubleS = longDouble(s);

        return (single.length() > doubleS.length()) ? single : doubleS;


    }

    String longSingle(String s) {
        int max = 0;
        int length = s.length();
        int leftP = 0;
        int rightP = 0;
        for (int i = 1; i < length ; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                if ((right - left) > max) {
                    leftP = left;
                    rightP = right;
                    max = right - left+1;
                }
                left--;
                right++;
            }
        }
        if (max == 0) {
            return s.substring(0,1);
        }
        return s.substring(leftP, rightP+1);
    }

    String longDouble(String s) {
        int max = 0;
        int length = s.length();
        int leftP = 0;
        int rightP = 0;
        for (int i = 0; i < length ; i++) {
            int left = i;
            int right = i+1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                if ((right - left+1) >= max) {
                    leftP = left;
                    rightP = right;
                    max = right - left+1;
                }
                left--;
                right++;
            }
        }
        if (max == 0) {
            return "";
        }
        return s.substring(leftP, rightP + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

