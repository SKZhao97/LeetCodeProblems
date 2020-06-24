import java.util.Arrays;

/**
 * 957. Prison Cells After N Days
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * June 23rd
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N%14 == 0 ? 14 : N%14;

        int[] prev = null;
        for(int i = 0; i < N; i++) {
            prev = new int[8];
            for (int j = 0; j < 8; j++) {
                if (j == 0 || j == 7) {
                    prev[j] = 0;
                } else {
                    prev[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
                }
            }
            cells = prev;
        }
        return cells;
    }

    public static void main(String[] args) {
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
        int[] cells = new int[]{1,0,0,1,0,0,1,0};
        int N = 1000000000;
        System.out.println(Arrays.toString(prisonCellsAfterNDays.prisonAfterNDays(cells, N)));
    }
}
