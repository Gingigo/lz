package leetcode.leetcode.editor.cn;
//Given a list of non negative integers, arrange them such that they form the la
//rgest number. 
//
// Example 1: 
//
// 
//Input: [10,2]
//Output: "210" 
//
// Example 2: 
//
// 
//Input: [3,30,34,5,9]
//Output: "9534330"
// 
//

import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class _179_LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if("0".equals(strings[0])){
            return "0";
        }
        String result="";
        for (String string : strings) {
            result+=string;
        }
        return result;
    }

    public static void main(String[] args) {
        _179_LargestNumber _179LargestNumber = new _179_LargestNumber();
        int [] nums ={10,2};
        _179LargestNumber.largestNumber(nums);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

