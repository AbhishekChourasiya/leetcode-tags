
// https://leetcode.com/problems/inorder-successor-in-bst/

public class InorderSuccessorInBST {

  // O(log(n)) - Balanced BST
  // O(n) - Worst case
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) {
      return null;
    }

    TreeNode next = null;
    TreeNode c = root;
    while (c != null && c.val != p.val) {
      if (c.val > p.val) {
        next = c;
        c = c.left;
      } else {
        c = c.right;
      }
    }

    if (c == null) {
      return null;
    }

    if (c.right == null) {
      return next;
    }

    c = c.right;
    while (c.left != null) {
      c = c.left;
    }

    return c;
  }
}
