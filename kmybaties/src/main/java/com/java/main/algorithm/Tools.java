package com.java.main.algorithm;

/**
 * @auther: kai2.wang
 * @date: 2019/8/7 17:30
 * @description:
 * @version: 1.0
 */
public class Tools {

    public static void printData(String name,Integer[] data){
        System.out.println(name);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+"-----");
        }
        System.out.println("");
    }
}
