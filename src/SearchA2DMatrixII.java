/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * June 16th
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;

        while (col >= 0 && row <= matrix.length - 1) {
            int current = matrix[row][col];
            if (current == target)
                return true;
            else if (current > target)
                col--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        int[][] matrix = new int[][]{{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchA2DMatrixII.searchMatrix(matrix, target));
    }
}
