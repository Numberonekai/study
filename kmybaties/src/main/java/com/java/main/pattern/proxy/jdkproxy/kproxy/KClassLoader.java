package com.java.main.pattern.proxy.jdkproxy.kproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @auther: kai2.wang
 * @date: 2019/10/23 15:37
 * @description:
 * @version: 1.0
 */
public class KClassLoader extends ClassLoader {


    public static void main(String[] args) throws IOException {
        String str="package com.java.main.pattern.proxy.jdkproxy.demo2;\n" +
                "\n" +
                "/**\n" +
                " * @auther: kai2.wang\n" +
                " * @date: 2019/10/24 09:36\n" +
                " * @description:\n" +
                " * @version: 1.0\n" +
                " */\n" +
                "public class Test implements TS{\n" +
                "\n" +
                "    public Test() {\n" +
                "    }\n" +
                "\n" +
                "    public void test(){\n" +
                "        System.out.println(\"---------------\");\n" +
                "    }\n" +
                "}\n";
        File file=new File(KProxy.class.getResource("").getPath()+"Test.java");

        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaCompiler javaCompiler= ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManager=javaCompiler.getStandardFileManager(null,null,null);
        Iterable iterable=standardJavaFileManager.getJavaFileObjects(file);

        JavaCompiler.CompilationTask javaCompiler1=javaCompiler.getTask(null,standardJavaFileManager,null,null,null,iterable);
        javaCompiler1.call();
        standardJavaFileManager.close();

        KClassLoader kClassLoader=new KClassLoader();
        Class clazz=kClassLoader.findClass("Test");
        try {
           Object kMeipo=clazz.newInstance();
           TS ts= (TS) kMeipo;
           ts.test();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Class<?> findClass(String name) {
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
