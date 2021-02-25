package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Leexiaobu
 * @date 2020-09-19 21:22:41
 */
interface  a{
    void doit();
}
interface  b{
    void doiaat();
}
public class Demo {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//
////        int result = getResult(5, "2 6 7 7 10");
////
////        System.out.println(result);
//    }

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextInt()) {
            int x = reader.nextInt();
            System.out.println(2*x);
        }
    }




        static   int getResult(int n, String nums) {
        String[] s = nums.split(" ");
        int[] numArrays = new int[n];
        for (int i = 0; i < s.length; i++) {
            numArrays[i] = Integer.parseInt(s[i]);
        }
//        排序
        Arrays.sort(numArrays);
        //找到一队减一个
        int ans = n;
        int point = 0;
        //找分界线
        for (int i = 0; i < numArrays.length; i++) {
            if (3 * numArrays[i] > numArrays[numArrays.length - 1]) {
                point = i;
                //跳出当前循环
                break;
            }
        }
        int left = point - 1;
        int right = n - 1;
        while (left >= 0 && right > point) {
            if (3 * numArrays[left] <= numArrays[right]) {
                left--;
                right--;
                ans--;
            } else {
                left--;
            }
        }
        return ans;
    }

}
