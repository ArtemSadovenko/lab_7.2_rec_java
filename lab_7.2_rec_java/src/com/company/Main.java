package com.company;

import java.util.Random;

public class Main {
    public static void  create(int[][] a, int col, int row, int l, int h, int i, int j) {
        Random rn = new Random();
        a[i][j] =  rn.nextInt(h - l) + l;
        if (j < col-1) {
            create(a, col, row, l, h, i, j + 1);
        }
        else if (i < row-1) {
            create(a, col, row, l, h, i + 1, 0);
        }
    }


    public static void print(int[][] a, int row, int col, int i, int j ) {

        if (j == 0) {
            System.out.print("|");
        }

        System.out.printf("%4d" ,a[i][j]);

        if (j == col-1) {
            System.out.print( "|");
            System.out.println();
        }

        if (j < col-1) {
            print(a, row, col, i, j + 1);
        }
        else if (i < row-1) {
            print(a, row, col, i + 1, 0);
        }
        else {
            System.out.println();
        }
    }

    public static void change(int[][] a, int row, int col, int j) {
        int i_max;
        int i_min;
        int tmp;

        i_min = min(a, row, j, 0, 0, a[0][j]);
        i_max = max(a, row, j - 1, 0, 0, a[0][j-1]);

        tmp = a[i_max][j - 1];
        a[i_max][j - 1] = a[i_min][j];
        a[i_min][j] = tmp;

        if (j < col-2 ) {
            change(a, row, col, j + 2);
        }
    }

    public static int max(int[][] a, int row, int j, int i, int i_max, int a_max) {
        if (a[i][j] > a_max) {
            a_max = a[i][j];
            i_max = i;
        }

        if (i < row -1  ) {
            return max(a, row, j, i + 1, i_max, a_max);
        }
        else {
            return i_max;
        }
    }

    public static int min(int[][] a, int row, int j, int i, int i_min, int a_min) {
        if (a[i][j] < a_min) {
            a_min = a[i][j];
            i_min = i;
        }

        if (i < row - 1) {
            return min(a, row, j, i + 1, i_min, a_min);
        }
        else{
            return i_min;
        }
    }


    public static void main(String[] args) {
        int k = 4;
        int n = 6;

        int l = -15;
        int h = 15;

        int[][] a = new int[k][n];

        create(a, n, k, l, h, 0, 0);

        print(a, k, n, 0, 0);

        change(a, k, n, 1);

        print(a, k, n, 0, 0);
    }
}
