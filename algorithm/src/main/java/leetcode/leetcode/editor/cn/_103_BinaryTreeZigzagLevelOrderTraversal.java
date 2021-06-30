package leetcode.leetcode.editor.cn;
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 450 👎 0

//_103_BinaryTreeZigzagLevelOrderTraversal
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class _103_BinaryTreeZigzagLevelOrderTraversal {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    if (root == null) {
      return ans;
    }
    boolean flag = true;
    LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);
    while (nodeQueue.size() > 0) {
      int tempSize = nodeQueue.size();
      TreeNode poll;
      List<Integer> subList = new ArrayList<>();
      for (int i = 0; i < tempSize; i++) {
        if (flag) {
          poll = nodeQueue.remove();
          subList.add(poll.val);
          if (poll.left != null) {
            nodeQueue.add(poll.left);
          }
          if (poll.right != null) {
            nodeQueue.add(poll.right);
          }
        } else {
          poll = nodeQueue.removeLast();
          subList.add(poll.val);
          if (poll.right != null) {
            nodeQueue.addFirst(poll.right);
          }
          if (poll.left != null) {
            nodeQueue.addFirst(poll.left);
          }
        }
      }
      flag = !flag;
      ans.add(subList);
    }
    return ans;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
