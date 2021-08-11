package com.lyh.offer;

/**
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列
 都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 个整数，判断数组中是否含有该整数。
 思路：从右上角或左下角开始找，逐行排除，或者用二分法查找
 * Created by lvyanghui
 * 2021/8/10 21:46
 */
public class BinarySearch {


    public static boolean find1(int[][] array, int target){
        if(array == null || array.length == 0){
            return false;
        }

        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column >= 0){
            if(array[row][column] == target){
                return true;
            }
            if(array[row][column] > target){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static boolean find2(int[][] array, int target){
        if(array == null || array.length == 0){
            return false;
        }

        int rowLow = 0;
        int rowHigh = array.length - 1;
        int columnLow = 0;
        int columnHigh = array[0].length - 1;
        while (rowLow <= rowHigh && columnLow <= columnHigh){
            int rowMid = (rowLow + rowHigh) / 2;
            int columnMid = (columnLow + columnHigh) / 2;
            if(array[rowMid][columnMid] == target){
                return true;
            }
            if(array[rowMid][columnMid] > target){
                rowHigh = rowMid - 1;
                columnHigh = columnMid - 1;
            }else{
                rowLow = rowMid + 1;
                columnLow = columnMid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        int[][] array1 = {
                {1,2,3,4,5},
                {2,3,4,5,6},
                {3,4,5,6,7},
                {4,5,6,7,8}
        };
        System.out.println(find1(array1,8));
        System.out.println(find2(array1,18));
    }
}
