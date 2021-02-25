package leetcode.leetcode.editor.cn;

//Given n, how many structurally unique BST's (binary search trees) that store v
//alues 1 ... n? 
//
// Example: 
//
// 
//Input: 3
//Output: 5
//Explanation:
//Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划
/*结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
当1为根节点时，其左子树节点个数为0，
右子树节点个数为n-1，同理当2为根节点时，
其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)*/
//leetcode submit region begin(Prohibit modification and deletion)
class _96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int i = new _96_UniqueBinarySearchTrees().numTrees(10);
        System.out.println(i);
    }

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    //    动态规划
    public int numTrees2(int n) {
        if (n == 1 || n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[(i - j)];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

