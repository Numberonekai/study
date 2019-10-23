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
//        Demo.sheelSort("希尔", getData());
        //快速排序
        Demo.quickSort("快速", getData());

        //裴波那契数列

    }

    private static Integer[] getData() {
        return new Integer[]{8,9,1,7,2,3,5,4,6,0};
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
//        for (int i = 1; i < data.length - 1; i++) {
//            for (int j = i + 1; j >= 1; j--) {
//                if (data[j - 1] >= data[j]) {
//                    int tmp = data[j];
//                    data[j] = data[j - 1];
//                    data[j - 1] = tmp;
//                } else {
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < data.length - 1; i++) {
            int current=data[i+1];
            int pre=i;
            while(pre>=0 && data[pre]>=current){
                data[pre+1]=data[pre];
                pre--;
            }
            data[pre+1]=current;
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

    /**
     * 希尔排序
     * @param name
     * @param data
     */
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
     * 快速排序方法
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static Integer[] QuickSort(Integer[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        Integer smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static Integer partition(Integer[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 快速排序
     *
     * @param data
     */
    public static void quickSort(String name, Integer[] data) {
        QuickSort(data,0,data.length-1);
        Tools.printData(name, data);
    }
}
