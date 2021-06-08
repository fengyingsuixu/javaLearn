package com.lyh.sort;

/**
 * Created by lvyanghui
 * 2021/5/31 20:51
 */
public class ShellSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        for (int gap = unsorted.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < unsorted.length; i++){
                int j;
                T temp = unsorted[i];
                for(j = i; j  >= gap && temp.compareTo(unsorted[j - gap]) < 0; j -= gap){
                    unsorted[j] = unsorted[j - gap];
                }
                unsorted[j] = temp;
            }
        }
        return unsorted;
    }

    public static void main(String[] args) {
        //Integer[] iArray = {5, 8, 2, 14, 9};
        Integer[] iArray = {15, 13, 11, 10, 9};
        //Integer[] iArray = {1, 4, 7, 9, 15};
        //Integer[] iArray = {4, 23, 6, 78, 1, 54, 231, 9, 12,78};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(iArray);
        SortUtils.print(iArray);

        String[] strings = {"c", "a", "e", "b", "d"};
        shellSort.sort(strings);
        SortUtils.print(strings);
    }
}
