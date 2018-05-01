package LeetCode.Arrays;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,1,1},{2,0,2,2},{3,3,3,3},{4,4,4,4}};
        System.out.println("Input Matrix:");
        printMatrix(input);
        System.out.println("After Nullifying");
        processZeroMatrix(input);
        printMatrix(input);
    }

    private static void processZeroMatrix(int[][] input) {

        boolean[] row = new boolean[input.length];
        boolean[] column = new boolean[input[0].length];

        for(int i=0;i<input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j]==0){
                    row[i]=true;
                    column[j]=true;
                }
            }
        }

        for(int i=0; i<row.length; i++){
            if(row[i]) {
                nullifyRow(input, i);
            }
        }

        for(int j=0; j<column.length; j++){
            if(column[j]) {
                nullifyColumn(input, j);
            }
        }
    }

    private static void nullifyColumn(int[][] input, int j) {

        for(int k=0; k<input[j].length; k++){
            input[k][j] = 0;
        }
    }

    private static void nullifyRow(int[][] input, int i) {
        for(int k=0; k<input[i].length; k++){
            input[i][k] = 0;
        }
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
