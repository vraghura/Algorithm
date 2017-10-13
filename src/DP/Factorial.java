package DP;

import java.util.Scanner;

/**
 * Created by vigneshwarraghuram on 10/12/17.
 *
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/
 *
 *
 */


public class Factorial {


    public static void main(String args[] ) throws Exception {


//Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=1;i<=t;i++ ){
            int n = s.nextInt();
            int []fact = new int[n + 1];
            fact[0] = fact[1] = 1;
            for(int j=2;j<=n;++j){
                fact [j] = j * fact[j-1];
            }
            System.out.println(fact[n]);
        }
    }
}

