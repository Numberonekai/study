package com.java.main.pattern.proxy.jdkproxy.demo2;

import java.io.*;

/**
 * @auther: kai2.wang
 * @date: 2019/10/23 15:37
 * @description:
 * @version: 1.0
 */
public class KClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) {
        String str = KClassLoader.class.getPackage().getName() + "." + name;

        String path = KClassLoader.class.getResource("").getPath();
        File file = new File(path);
        if (file != null) {
            File file1 = new File(file, name.replace("\\.", "/" )+ ".class");

            if (file1.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file1);
                    ByteArrayOutputStream  out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while ((len = fileInputStream.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(str, out.toByteArray(), 0, out.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;

    }
}
