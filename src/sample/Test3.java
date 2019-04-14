package sample;

import java.util.Scanner;

/**
 * ������3����ά�����еĲ���
 * ��Ŀ��
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳������
 * ���һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class Test3 {
    /**˼·������ǵ��������һ�еĵ�һ��������5 ���е���ֹ �Ҳ���
     * ���һ�е�����������5 ��һ����ֹ
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
