package com.wk.study.demo.thread;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @auther: kai2.wang
 * @date: 2019/10/22 14:30
 * @description:
 * @version: 1.0
 */
public class Demo {

    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 10000; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        String str=getGetClass();
        File file=new File(Demo.class.getResource("").getPath()+"$proxy0.java");

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
    }

    public static String getGetClass(){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.java.main.pattern.proxy.jdkproxy.demo2;\n" +
                "import com.java.main.pattern.proxy.jdkproxy.demo.Person;\n" +
                "import java.lang.reflect.*;\n" +
                "class $Proxy0 implements com.java.main.pattern.proxy.jdkproxy.demo.Person{\n" +
                "    KInvocationHandler h;\n" +
                "    public $Proxy0(KInvocationHandler h) {\n" +
                "        this.h = h;}\n" +
                "        @Override\n" +
                "    public void findLove() {\n" +
                "        try{\n" +
                "            Method m = com.java.main.pattern.proxy.jdkproxy.demo.Person.class.getMethod(\"findLove\",new Class[]{});\n" +
                "            this.h.invoke(this,m,new Object[]{});\n" +
                "        }catch(Error _ex) { }catch(Throwable e){\n" +
                "            throw new UndeclaredThrowableException(e);\n" +
                "        }}}\n");
        return sb.toString();
    }
}
