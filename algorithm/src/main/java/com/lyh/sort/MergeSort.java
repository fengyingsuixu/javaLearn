package com.lyh.sort;

/**
 * Created by lvyanghui
 * 2021/5/31 20:51
 */
public class MergeSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        doSort(unsorted,0, unsorted.length - 1);
        return unsorted;
    }

    private static <T extends Comparable<T>> void doSort(T[] arr, int left, int right){

        if(left < right){
            int mid = (left + right) / 2;
            doSort(arr,left, mid);
            doSort(arr,mid + 1, right);
            merge(arr,left,mid,right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right){
        int length = right - left + 1;
        T[] temp = (T[])new Comparable[length];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){
            if(arr[i].compareTo(arr[j]) < 0){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= right){
            temp[k++] = arr[j++];
        }

        System.out.println("开始merge，left=" + left + " mid=" + mid + " right=" + right);
        System.arraycopy(temp,0, arr, left, length);
    }

    public static void main(String[] args) {
        //Integer[] iArray = {5, 8, 2, 14, 9};
        //Integer[] iArray = {15, 13, 11, 10, 9};
        //Integer[] iArray = {1, 4, 7, 9, 15};
        Integer[] iArray = {4, 23, 6, 78, 1, 54, 231, 9, 12,78};
        MergeSort shellSort = new MergeSort();
        shellSort.sort(iArray);
        SortUtils.print(iArray);

        String[] strings = {"c", "a", "e", "b", "d"};
        shellSort.sort(strings);
        SortUtils.print(strings);
    }
}
