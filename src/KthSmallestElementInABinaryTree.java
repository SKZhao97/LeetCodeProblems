import java.util.LinkedList;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABinaryTree {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(true) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}
