import java.util.*;

/**
 * 1519. Number of Nodes in the Sub-Tree With the Same Label
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 * July 19th
 */
public class NumberOfNodesInSubTreeWithSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }
        int[] ans = new int[n];
        Set<Integer> seen = new HashSet<>();
        dfs(map, 0, labels, ans, seen);
        return ans;
    }

    private int[] dfs(Map<Integer, List<Integer>> map, int node, String labels, int[] ans, Set<Integer> seen) {
        int[] cnt = new int[26];
        if (seen.add(node)) {
            char ch = labels.charAt(node);
            for (int child : map.getOrDefault(node, Collections.emptyList())) {
                int[] temp = dfs(map, child, labels, ans, seen);
                for (int i = 0; i < 26; i++) {
                    cnt[i] += temp[i];
                }
            }
            ++cnt[ch - 'a'];
            ans[node] = cnt[ch - 'a'];
        }


        return cnt;
    }

    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithSameLabel numberOfNodesInTheSubTreeWithSameLabel = new NumberOfNodesInTheSubTreeWithSameLabel();
        int n = 7;
        int[][] edges = new int[][]{{0,1}, {0,2}, {1,4},{1,5},{2,3},{2,6}};
        String s = "abaedcd";
        System.out.println(Arrays.toString(numberOfNodesInTheSubTreeWithSameLabel.countSubTrees(n, edges, s)));
    }
}
