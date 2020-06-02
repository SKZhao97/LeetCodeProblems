import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * June 1st
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }


    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Order(res, root);
        return res;
    }
    public void Order(List<Integer> res , TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        Order(res, root.left);
        Order(res,root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/*
 *   preorder 直接用 stack;
 *   inorder 用 stack + cur;
 *   postorder 用 stack + cur + prev;
 */