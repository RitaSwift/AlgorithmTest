package sample;

import java.util.Scanner;

/**
 * 面试题3：二维数组中的查找
 * 题目：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test3 {
    /**思路：这个是递增，如果一行的第一个数大于5 所有的终止 找不到
     * 如果一行的其他数大于5 这一行终止
     */
    public static boolean function(int[][] matrix, int num){
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < columns;j++){
                if(j == 0 && matrix[i][j] > num){
                    return false;
                }
                if(matrix[i][j] > num){
                    break;
                }
                if(matrix[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(function(matrix,7));
        System.out.println(function(matrix,5));
        System.out.println(function(matrix,1));
        System.out.println(function(matrix,15));
        System.out.println(function(matrix,0));
        System.out.println(function(matrix,16));
    }


}
