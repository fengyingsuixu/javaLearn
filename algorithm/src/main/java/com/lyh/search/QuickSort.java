package com.lyh.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvyanghui
 * 2021/8/3 22:14
 */
public class QuickSort {

    private static List<Integer> quickSort(List<Integer> list){
        List<Integer> sort = new ArrayList<>();
        if (list.size() < 2){
            return list;
        }else{
            Integer pivot = list.get(0);
            List<Integer> less = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) <= pivot){
                    less.add(list.get(i));
                }
            }
            List<Integer> greater = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) > pivot){
                    greater.add(list.get(i));
                }
            }

            List<Integer> integers = quickSort(less);
            List<Integer> integers1 = quickSort(greater);
            sort.addAll(integers);
            sort.add(pivot);
            sort.addAll(integers1);
            return sort;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5,6,3,7,9,1,2,10,18,0,4,90,56,44);
        System.out.println(quickSort(list));
    }
}
