package io.haitaoc.util;

public class PrintArray {

    public static void print(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void print(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[0].length ; j++) {
                System.out.printf("%3d ",array[i][j]);
            }
            System.out.println();
        }
    }
    public static void print(boolean[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[0].length ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void print(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[0].length ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }




}
