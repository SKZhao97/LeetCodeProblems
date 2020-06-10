import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1192. Critical Connections in a Network
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * June 10th
 */
public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /*
           We record the timestamp that we visit each node. For each node, we check every neighbor except its parent
           and return a smallest timestamp in all its neighbors. If this timestamp is strictly less than the node's
           timestamp, we know that this node is somehow in a cycle. Otherwise, this edge from the parent to this node
           is a critical connection
         */
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for(List<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        int[] timer = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int []timeStampAtThatNode = new int[n];
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        return results;
    }

    public void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int[] timer, boolean[] visited, List<List<Integer>> results, int[] timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        int currentTimeStamp = timeStampAtThatNode[node];

        for(int oneNeighbour : graph[node]) {
            if(oneNeighbour == parent) continue;
            if(!visited[oneNeighbour])
                criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtThatNode);
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbour]);
            if(currentTimeStamp < timeStampAtThatNode[oneNeighbour]) results.add(Arrays.asList(node, oneNeighbour));
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list2.add(1);
        list2.add(2);
        list3.add(2);
        list3.add(0);
        list4.add(1);
        list4.add(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        int n = 4;
        CriticalConnectionsInANetwork criticalConnectionsInANetwork = new CriticalConnectionsInANetwork();
        System.out.println(criticalConnectionsInANetwork.criticalConnections(n, list));
    }
}
