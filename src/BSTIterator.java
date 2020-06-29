import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * June 28th
 */
class BSTIterator {

    Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        queue.add(root.val);
        inOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(15);
        root.left = t1;
        root.right = t2;
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(20);
        t2.left = t3;
        t2.right = t4;
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
//        iterator.next();    // return 3
//        iterator.next();    // return 7
//        iterator.hasNext(); // return true
//        iterator.next();    // return 9
//        iterator.hasNext(); // return true
//        iterator.next();    // return 15
//        iterator.hasNext(); // return true
//        iterator.next();    // return 20
//        iterator.hasNext(); // return false
    }
}
