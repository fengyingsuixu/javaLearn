package com.lyh.sort;

/**
 * Created by lvyanghui
 * 2021/5/25 16:23
 */
public interface SortAlgorithm {

    <T extends Comparable<T>> T[] sort(T[] unsorted);
}
