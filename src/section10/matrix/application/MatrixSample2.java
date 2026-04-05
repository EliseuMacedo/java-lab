package section10.matrix.application;

import java.util.Locale;
import java.util.Scanner;

/*
    Fazer um programa para ler dois números inteiros M e N, e depois ler
    uma matriz de M linhas por N colunas contendo números inteiros,
    podendo haver repetições. Em seguida, ler um número inteiro X que
    pertence à matriz. Para cada ocorrência de X, mostrar os valores à
    esquerda, acima, à direita e abaixo de X, quando houver, conforme
    exemplo abaixo.

    3 4
    10 8 15 12
    21 11 23 8
    14 5 13 19
    8

    Position 0,1:
    Left: 10
    Right: 15
    Down: 11
    Position 1,3:
    Left: 23
    Up: 12
    Down: 19
 */

public class MatrixSample2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        // matrix.length is the number of rows in the matrix;
        // matrix[i].length is the number of columns in the matrix;

        /*imput matrix*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        /* Show values ​​around x (left, up, right, down)*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                if (value == x) {
                    System.out.println("Position " + i + "," + j + ":");

                    if (j > 0) {
                        int left = matrix[i][j - 1];
                        System.out.println("Left: " + left);
                    }

                    if (i > 0) {
                        int up = matrix[i - 1][j];
                        System.out.println("Up: " + up);
                    }

                    if (j + 1 < matrix[i].length) {
                        int right = matrix[i][j + 1];
                        System.out.println("Right: " + right);
                    }

                    if (i + 1 < matrix[i].length) {
                        int down = matrix[i + 1][j];
                        System.out.println("Down: " + down);
                    }
                }
            }
        }


        sc.close();

    }
}
