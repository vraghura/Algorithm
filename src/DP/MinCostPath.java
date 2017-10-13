package DP;

import java.util.Scanner;

import static java.lang.Integer.min;

/**
 * Created by vigneshwarraghuram on 10/12/17.
 */
public class MinCostPath {

    public static void main(String[] args) {

/*
        Scanner s = new Scanner(System.in);


        System.out.println("Enter the size of the matrix:"+"\n");
        System.out.print("Rows:");
        int rows = s.nextInt();
        System.out.println("Columns:");
        int columns = s.nextInt();
        int input[][] = new int[rows][columns];



        System.out.println("Enter the matrix:" + '\n');
        for (int i = 0; i < rows; i++) {
            System.out.println("Row" + (i + 1) +" : ");
            for (int j = 0; j < columns; j++) {
                System.out.println("Column" + (j + 1)+" : ");
                input[i][j] = s.nextInt();
            }
        }
*/

        int input[][] = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};

        printInput(input, 3, 4);

        mincost(input,3, 4);
    }

    private static void mincost(int[][] input, int m, int n) {

        int t[][] = new int[m][n];

        int sum = 0;
        for(int i=0; i < n; i++){
            t[0][i] = sum + input[0][i];
            sum = t[0][i];
        }
        sum = 0;
        for(int i=0; i < m; i++){
            t[i][0] = sum + input[i][0];
            sum = t[i][0];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                t[i][j] = input[i][j] + min(t[i-1][j], t[i][j-1]);
            }
        }
        System.out.println("");
        System.out.println("Min Cost-"+t[m-1][n-1]);
    }



    private static void printInput(int[][] input, int m, int n) {

        System.out.println("Input:"+"\n");
        for (int i = 0; i < m; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print("\t"+input[i][j]);
            }
        }
    }
}
