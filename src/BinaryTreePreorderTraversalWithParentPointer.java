/**
 * Preorder Treverse A Binary Tree With Parent Pointer
 */
public class BinaryTreePreorderTraversalWithParentPointer {
    public static void printPreorder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            System.out.println(cur.val);
            if (cur.left != null) {
                cur = cur.left;
            } else if (cur.right != null) {
                cur = cur.right;
            } else {
                while (cur.parent != null && (cur.parent.right == null || cur == cur.parent.right)){
                    cur = cur.parent;
                }
                if (cur.parent == null) break;
                cur = cur.parent.right;
            }
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
