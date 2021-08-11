package com.lyh.offer;

/**
 * Created by lvyanghui
 * 2021/8/11 22:46
 */
public class Replace {

    public static String replace(StringBuffer stringBuffer){
        if(stringBuffer == null || stringBuffer.length() == 0){
            return null;
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0, size = stringBuffer.length(); i < size; i++) {
            if(String.valueOf(stringBuffer.charAt(i)).equals(" ")){
                result.append("%20");
            }else{
                result.append(stringBuffer.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sdjflsdkfj 好省得浪费空间违法 567657");
        System.out.println(replace(stringBuffer));
    }
}
