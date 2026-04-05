package section10.matrix.application;

import java.util.Locale;
import java.util.Scanner;

/*
    Fazer um programa para ler um número inteiro N e uma matriz de
    ordem N contendo números inteiros. Em seguida, mostrar a diagonal
    principal e a quantidade de valores negativos da matriz.

    Input:          Output:
    3               Main diagonal:
    5 -3 10         5 8 -4
    15 8 2          Negative numbers = 2
    7 9 -4
*/

public class MatrixSample1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[n][n];

        // matrix.length is the number of rows in the matrix;
        // matrix[i].length is the number of columns in the matrix;

        /*input matrix*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        /*output matrix*/
        System.out.println();
        System.out.println("Main diagonal: ");
        int negative = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
                if (matrix[i][j] < 0) {
                    negative++;
                }
            }
        }

        System.out.println();
        System.out.print("Negative numbers =  " + negative);
        System.out.println();

        sc.close();

    }
}
