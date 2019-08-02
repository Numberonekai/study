package com.java.main.serializable;

/**
 * @Auther: kai2.wang
 * @Date: 2019/8/1 18:29
 * @Description:
 */
public class SeriazableDemo {

    public static void main(String[] args) {
//        JavaFileSerializable javaSeriazble=new JavaFileSerializable();
//        JavaByteSerializable javaSeriazble=new JavaByteSerializable();
        XmlSerializable javaSeriazble=new XmlSerializable();
//        JSonSerializable javaSeriazble=new JSonSerializable();

        User user=new User();
        user.setName("Test");
        user.setId(18 );

        /**
         *
         */
        byte[] data=javaSeriazble.serializable(user);
        System.out.println(new String(data)+"----------"+data.length);
        User user1=javaSeriazble.deserializable(data);
        System.out.println(user1);


    }
}
