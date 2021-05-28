package com.lyh.sort;

/**
 * Created by lvyanghui
 * 2021/5/28 10:36
 */
public class SelectionSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        for(int i = 0, size = unsorted.length; i < size - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < size; j++){
                if(unsorted[minIndex].compareTo(unsorted[j]) > 0 ){
                    minIndex = j;
                }
            }
            SortUtils.swap(unsorted,i,minIndex);
        }
        return unsorted;
    }

    public static void main(String[] args) {
        Integer[] iArray = {5, 8, 2, 14, 9};
        //Integer[] iArray = {15, 13, 11, 10, 9};
        //Integer[] iArray = {1, 4, 7, 9, 15};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(iArray);
        SortUtils.print(iArray);
    }
}
