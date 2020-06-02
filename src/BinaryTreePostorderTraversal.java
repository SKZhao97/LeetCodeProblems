import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * June 1st
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == null || prev.right == null) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if(cur.right != null){
                    stack.push(cur.right);
                }
            } else if (cur.left == prev){
                if(cur.right != null) stack.push(cur.right);
            } else {
                list.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return list;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> postOrder = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //TreeNode node = root;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                postOrder.add(0, root.val);
                root = root.right;
            }
            root = stack.pop().left;
        }
        return postOrder;
    }
}
