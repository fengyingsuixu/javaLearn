package com.lyh.sort;

import java.util.Arrays;

/**
 * Created by lvyanghui
 * 2021/5/28 10:00
 */
public class SortUtils {

    public static <T extends Comparable<T>> boolean less (T v, T w){
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> boolean greater (T v, T w){
        return v.compareTo(w) > 0;
    }

    public static <T> boolean swap(T[] array, int x, int y){
        T tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
        return true;
    }

    public static void print(Object[] toPrint){
        System.out.println(Arrays.toString(toPrint));
    }
}
