/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 * June 16th
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s!= null && (isIdentical(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isIdentical (s.left, t.left) && isIdentical(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        TreeNode s = new TreeNode(3);
        TreeNode t = new TreeNode(4);
        System.out.println(subtreeOfAnotherTree.isSubtree(s, t));
    }
}
