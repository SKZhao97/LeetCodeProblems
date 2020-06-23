import java.util.Arrays;

/**
 * 593. Valid Square
 * https://leetcode.com/problems/valid-square/
 * June 22nd
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(Arrays.equals(p1,p2) || Arrays.equals(p2,p3) || Arrays.equals(p3,p4)){
            return false;
        }
        int[][] p={p1,p2,p3,p4};
        // Sort
        Arrays.sort(p, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);

        return calLength(p[0], p[1]) == calLength(p[1], p[3]) && calLength(p[1], p[3]) == calLength(p[3], p[2]) && calLength(p[3], p[2]) == calLength(p[2], p[0]) && calLength(p[0],p[3])==calLength(p[1],p[2]);
    }

    public double calLength(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }


    public static void main(String[] args) {
        ValidSquare validSquare = new ValidSquare();
        int[] p1 = new int[]{0,0};
        int[] p2 = new int[]{1,1};
        int[] p3 = new int[]{1,0};
        int[] p4 = new int[]{0,1};
        System.out.println(validSquare.validSquare(p1, p2, p3, p4));
    }
}
