package LeetCode.Arrays;

public class MatrixRotation {

    public static void main(String[] args) {

        int[][] input = new int[][]{{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        System.out.println("Input Matrix: Before Rotation");
        printMatrix(input);
        System.out.println("After Rotation");
        rotateMatrix(input);
    }

    private static void rotateMatrix(int[][] input) {
        int n = input.length;
        for(int layer=0; layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first; i<last; i++){
                int offset = i -first;
                int top = input[first][i];

                input[first][i] = input[last-offset][first];

                input[last-offset][first] = input[last][last-offset];

                input[last][last-offset] = input[i][last];

                input[i][last] = top;
            }
        }
        printMatrix(input);
    }

    private static void printMatrix(int[][] input) {

        for(int i=0;i<input.length; i++){
            for(int j=0; j<input[0].length;j++){
                System.out.print("\t");
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}