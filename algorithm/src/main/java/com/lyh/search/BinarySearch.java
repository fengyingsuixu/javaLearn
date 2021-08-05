package com.lyh.search;

/**
 * Created by lvyanghui
 * 2021/7/31 15:58
 */
public class BinarySearch {

    public static int binarySearch(int[] ints, int value){
        int low = 0;
        int high = ints.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(value == ints[mid]){
                return mid;
            }
            if(value < ints[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch1(int low, int high, int[] ints, int value){

        if(low <= high){
            int mid = (low + high) / 2;
            if(value == ints[mid]){
                return mid;
            }
            if(value < ints[mid]){
                return binarySearch1(low,mid - 1, ints, value);
            }else {
                return binarySearch1(mid + 1, high, ints, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1,3,5,7,9};
        int i = binarySearch(ints, 7);
        System.out.println(i);
        int j = binarySearch1(0,ints.length - 1,ints,7);
        System.out.println(j);
    }
}
