package leetcode.leetcode.editor.cn;
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
//for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
// repeated sequences within the DNA. 
//
// Write a function to find all the 10-letter-long sequences (substrings) that o
//ccur more than once in a DNA molecule. 
//
// Example: 
//
// 
//Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//
//Output: ["AAAAACCCCC", "CCCCCAAAAA"]
// 
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class _187_RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() <= 10) {
            return list;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (map.containsKey(substring)) {
                if(map.get(substring)==0){
                    list.add(substring);
                    map.put(substring,1);
                }
            } else {
                map.put(substring, 0);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new _187_RepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//

