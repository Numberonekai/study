package com.java.main.algorithm;

/**
 * @auther: kai2.wang
 * @date: 2019/11/29 09:11
 * @description:
 * @version: 1.0
 */
public class Demo2 {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int start = 0;
        int end = data.length;

        selectById2(data, start, end, 5);


    }

    public static void selectById2(int[] data, int start, int end, int value) {
        if (start > end) {
            return;
        }
        int middle = (start + end) / 2;
        if (data[middle] > value) {
            selectById2(data, start, middle - 1, value);
        } else if (data[middle] < value) {
            selectById2(data, middle + 1, end, value);
        } else {
            System.out.println("--------" + middle);
        }
    }

    public static int selectById(int[] data, int start, int end, int value) {
        if (start > end) {
            return -1;
        }
        int middle = start + end / 2;
        if (data[middle] > value) {
            selectById(data, start, middle - 1, value);
        } else if (data[middle] < value) {
            selectById(data, middle + 1, end, value);
        }
        return middle;
    }

    public static void selectById1(int[] data, int start, int end, int value) {
        int middle = 0;
        while(start<=end){
            middle = (start + end) / 2;
            if(data[middle]>value){
                end=middle-1;
            }else if(data[middle]==value){
                System.out.println(middle);
                return;
            }else{
                start=middle+1;
            }
        }
//        int middle = (start + end) / 2;
//
//        while (data[middle] == value) {
//            if (data[middle] > value) {
//                end = middle;
//                middle = (start + end) / 2;
//            } else {
//                start = middle;
//                middle = (start + end) / 2;
//            }
//        }
        System.out.println(middle);
    }
}
