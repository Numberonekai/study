package com.java.main.algorithm;

/**
 * @auther: kai2.wang
 * @date: 2019/10/8 10:19
 * @description:
 * @version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            int data=liveTodata12(i);
            System.out.println(data);
        }
    }

    public static int liveTodata1(int i){
        if(i==0 || i==1){
            return 1;
        }
        return liveTodata1(i-1)+liveTodata1(i-2);
    }

    public static int liveTodata12(int i){
        int m=1;
        int n=1;
        int sum=0;
        if(i==0 || i==1){
            return 1;
        }
        for (int j = 2; j <= i; j++) {
            sum=m+n;
            m=n;
            n=sum;
        }
        return sum;
    }


//    public static int liveToData(int numb){
//        if(numb==0 || numb==1){
//            return 1;
//        }
//        return liveToData(numb-1)+liveToData(numb-2);
//    }
//
//    public static int liveToData2(int numb){
//        int sum=0;
//        int m=1,n=1;
//        if(numb==0 || numb==1){
//            return 1;
//        }
//        for (int i = 2; i <= numb; i++) {
//            sum=m+n;
//            m=n;
//            n=sum;
//        }
//        return sum;
//    }

}
