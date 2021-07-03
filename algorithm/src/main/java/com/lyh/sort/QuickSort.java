package com.lyh.sort;

import static com.lyh.sort.SortUtils.*;

/**
 * Created by lvyanghui
 * 2021/5/31 20:51
 */
public class QuickSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            System.out.println("pivot=" + pivot);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(T[] array, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        System.out.println("randomIndex=" + randomIndex);
        swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int left,  int right){
        int mid = (right + left) >>> 1;
        T pivot = arr[mid];

        while (left <= right){
            while(less(arr[left],pivot)){
                left++;
            }
            while(less(pivot,arr[right])){
                right--;
            }
            if(left <= right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //Integer[] iArray = {5, 8, 2, 14, 9};
        //Integer[] iArray = {15, 13, 11, 10, 9};
        //Integer[] iArray = {1, 4, 7, 9, 15};
        Integer[] iArray = {4, 23, 6, 78, 1, 54, 231, 9, 12,78};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(iArray);
        print(iArray);


        String[] strings = {"c", "a", "e", "b", "d"};
        quickSort.sort(strings);
        print(strings);

    }
}
