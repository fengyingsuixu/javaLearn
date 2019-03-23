package com.lyh;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**需要引入jar包 D:\develops\opencv\build\java\opencv-401.jar
 * 配置vm options -Djava.library.path=D:\develops\opencv\build\java\x64
 * Created by lvyanghui
 * 2019/3/22 22:48
 */
public class OpencvTest {

    static {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {

        //runtime.getTime.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //eye指令模仿 matlab里面的eye，创建单位矩阵
        Mat m = Mat.eye(3,3, CvType.CV_8UC1);
        System.out.println("m = " +m.dump());


    }
}
