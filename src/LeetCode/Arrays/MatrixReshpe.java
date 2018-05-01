package LeetCode.Arrays;

public class MatrixReshpe {

    public static void main(String[] args) {
        MatrixReshpe matrixReshpe = new MatrixReshpe();
        int[][] nums = new int[][]{{1, 2,3}, {3, 4}};
        System.out.println(matrixReshpe.matrixReshape(nums, 1, 6));
    }

    private int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int sizeLimit = nums.length * nums[0].length;

        if (nums.length == 0 || r * c != sizeLimit)
            return nums;
        int rows = 0, cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
}