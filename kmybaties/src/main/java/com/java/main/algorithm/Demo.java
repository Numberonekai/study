package com.java.main.algorithm;

/**
 * @auther: kai2.wang
 * @date: 2019/8/7 17:07
 * @description: 算法基础
 * @version: 1.0
 */
public class Demo {

    public static void main(String[] args) {

//        //冒泡
//        Demo.maoPaoSort("冒泡",getData());
//        //插入排序
//        Demo.insertSort("插入",getData());
//        //选择排序
//        Demo.selectSort("选择",getData());
//        //希尔排序
        Demo.sheelSort("希尔", getData());
    }

    private static Integer[] getData() {
        return new Integer[]{1, 7, 9, 2, 8, 5};
    }

    /**
     * 冒泡
     *
     * @param data
     */
    public static void maoPaoSort(String name, Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int max = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = max;
                }
            }
        }
        Tools.printData(name, data);
    }

    /**
     * 插入排序
     *
     * @param name
     * @param data
     */
    public static void insertSort(String name, Integer[] data) {
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = i + 1; j >= 1; j--) {
                if (data[j - 1] >= data[j]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
        Tools.printData(name, data);
    }


    /**
     * 选择排序
     *
     * @param name
     * @param data
     */
    public static void selectSort(String name, Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int m = i;
            for (int j = i + 1; j < data.length; j++) {
                if (min > data[j]) {
                    min = data[j];
                    m = j;
                }
            }
            data[m] = data[i];
            data[i] = min;
        }
        Tools.printData(name, data);
    }

    public static void sheelSort(String name, Integer[] data) {
        int group = data.length / 2;
        while (group != 0) {
            for (int i = group; i < data.length; i++) {
                int tmp=data[i];
                int pre=i-group;
                while (pre>=0 && data[pre]>=tmp){
                    data[pre+group]=data[pre];
                    pre-=group;
                }
                data[pre+group]=tmp;
            }
            group=group/2;
        }
        Tools.printData(name, data);
    }


    public static void mergeSort(String name, Integer[] data) {

    }

    private static void merge(Integer[] data) {

    }


    /**
     * 快速排序
     *
     * @param data
     */
    public static void quickSort(Integer[] data) {


    }
}
