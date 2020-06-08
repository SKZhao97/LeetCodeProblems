/**
 * 256. Paint House
 * https://leetcode.com/problems/paint-house/
 * June 7th
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }

    public static void main(String[] args) {
        int[][] house = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCost(house));
    }
}
