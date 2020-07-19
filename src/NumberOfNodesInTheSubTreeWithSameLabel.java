import java.util.*;

/**
 *
 */
public class NumberOfNodesInTheSubTreeWithSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] res = new int[n];
        boolean[] vis = new boolean[n];
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            if (vis[edge[0]]) {
                first = edge[0];
                second = edge[1];
            }
            if (vis[edge[1]]) {
                first = edge[1];
                second = edge[0];
            }
            vis[edge[0]] = true;
            vis[edge[1]] = true;
            List<Integer> list = map.getOrDefault(first, new ArrayList());
            list.add(second);
            map.put(first, list);
        }
        for (int i = 0; i < n; i++) {
            int ans = countSubTreesRecursive(labels.charAt(i), map.get(i), labels, map) + 1;
            res[i] = ans;
        }
        return res;
    }

    public int countSubTreesRecursive(char ch, List<Integer> list, String labels, Map<Integer, List<Integer>> map) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int temp = 0;
        for (int k : list) {
            if (labels.charAt(k) != ch) {
                temp += countSubTreesRecursive(ch, map.get(k), labels, map);
            } else {
                temp++;
                temp += countSubTreesRecursive(ch, map.get(k), labels, map);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithSameLabel numberOfNodesInTheSubTreeWithSameLabel = new NumberOfNodesInTheSubTreeWithSameLabel();
        int n = 6;
        //int[][] edges = new int[][]{{0,1},{0,2},{1,3},{0,4}};
        int[][] edges = new int[][]{{0,1},{0,2},{1,3},{3,4},{4,5}};
        //int[][] edges = new int[][]{{0,2},{0,3},{2,1}};
        //String labels = "aabab";
        String labels = "cbabaa";
        //String labels = "aeed";
        System.out.println(Arrays.toString(numberOfNodesInTheSubTreeWithSameLabel.countSubTrees(n, edges, labels)));
    }
}
