package com.lyh.sort;

/**
 * Created by lvyanghui
 * 2021/5/25 15:01
 */
public class BubbleSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        for(int i = 0, size = unsorted.length; i < size - 1; i++){
            for(int j = 0; j < size - 1 - i; j++){
                if(unsorted[j].compareTo(unsorted[j+1]) > 0 ){
                    SortUtils.swap(unsorted,j,j+1);
                }
            }
        }
        return unsorted;
    }


    public static void main(String[] args) {

        Integer[] iArray = {5, 8, 2, 14, 9};
        //Integer[] iArray = {15, 13, 11, 10, 9};
        //Integer[] iArray = {1, 4, 7, 9, 15};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(iArray);
        SortUtils.print(iArray);
    }
}
