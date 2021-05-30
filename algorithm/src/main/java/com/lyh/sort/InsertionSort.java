package com.lyh.sort;

/**
 * Created by lvyanghui
 * 2021/5/30 10:53
 */
public class InsertionSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        for(int i = 1, size = unsorted.length; i < size; i++){
            T insertValue = unsorted[i];
            int j;
            for(j = i - 1; j >= 0 && insertValue.compareTo(unsorted[j]) < 0; j--){
                unsorted[j + 1] = unsorted[j];
            }
            unsorted[j + 1] = insertValue;
        }
        return unsorted;
    }

    public static void main(String[] args) {
        //Integer[] iArray = {5, 8, 2, 14, 9};
        Integer[] iArray = {15, 13, 11, 10, 9};
        //Integer[] iArray = {1, 4, 7, 9, 15};
        //Integer[] iArray = {4, 23, 6, 78, 1, 54, 231, 9, 12,78};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(iArray);
        SortUtils.print(iArray);

        String[] strings = {"c", "a", "e", "b", "d"};
        insertionSort.sort(strings);
        SortUtils.print(strings);
    }
}
