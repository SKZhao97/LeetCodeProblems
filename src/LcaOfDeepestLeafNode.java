public class LcaOfDeepestLeafNode {
    static TreeNode curLCA = null;
    static int maxDepth = 0;

    private static int postOrder(TreeNode root, int depth) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                curLCA = root;
                maxDepth = depth;
            }
            return depth;
        }
        int left = postOrder(root.left, depth + 1);
        int right = postOrder(root.right, depth + 1);
        if (left == right && left >= maxDepth) {
            maxDepth = Math.max(left, maxDepth);
            curLCA = root;
        }
        return Math.max(left, right);
    }
}
