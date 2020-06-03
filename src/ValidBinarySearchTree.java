/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * June 2nd
 */
public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        int val = node.val;
        if (low != null && val <= low) return false;
        if (high != null && val >= high) return false;

        if (!dfs(node.right, val, high)) return false;
        if (!dfs(node.left, low, val)) return false;
        return true;
    }
}
