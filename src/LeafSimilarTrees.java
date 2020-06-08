import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/
 * June 6th
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if (leaves1.size() == leaves2.size()) {
            for (int i=0; i<leaves1.size(); i++){
                if (leaves1.get(i) != leaves2.get(i))
                    return false;
            }
            return true;
        }
        return false;
    }
    public void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
