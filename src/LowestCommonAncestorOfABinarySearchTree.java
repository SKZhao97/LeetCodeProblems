/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * May 31st
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /** Iterative **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    /** Recursive **/
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        // Got to check if p and q is null as well;
        if(root == null) return root;
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestorRecursive(root.left, p, q);
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestorRecursive(root.right, p, q);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
