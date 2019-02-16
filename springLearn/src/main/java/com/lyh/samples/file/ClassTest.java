package com.lyh.samples.file;

import java.io.File;

/**
 * Created by lvyanghui
 * 2019/2/16 16:22
 */
public class ClassTest {

    public static void main(String[] args) {
        File file = new File("com/lyh/samples");

        System.out.println(file.getAbsolutePath());
        File[] files = file.listFiles();
        for(File ff : files){
            System.out.println(ff.getName());
        }

    }
}
