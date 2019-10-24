package com.java.main.pattern.proxy.jdkproxy.cglibproxy;

/**
 * @auther: kai2.wang
 * @date: 2019/10/24 17:21
 * @description:
 * @version: 1.0
 */
public class CglibTest {

    public static void main(String[] args) {

//        String str="abc";
//        char[] chars=str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] > 'a' - 1 && chars[i] < 'z' + 1) {
//                chars[i] -= 32;//大于A小于Z +32 //大于a小于z -32
//            }
//        }
//        System.out.println(String.valueOf(chars));




        String data="abc";
        char[] chars=data.toCharArray();
        chars[0]-=32;
        System.out.println(String.valueOf(chars));
//
//        System.out.println(CglibTest.lowerFirstCase("abc"));
    }

    public static String lowerFirstCase(String str){
        char [] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
