package com.java.main.pattern.proxy.jdkproxy.demo2;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: kai2.wang
 * @date: 2019/10/23 15:16
 * @description:
 * @version: 1.0
 */
public class KProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(KClassLoader loader,
                                          Class<?>[] interfaces,
                                          KInvocationHandler h)
            throws IllegalArgumentException, IOException {

        String str=getGetClass(interfaces);
        File file=new File(KProxy.class.getResource("").getPath()+"$proxy0.java");

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

        try {
            Class clazz=loader.findClass("$proxy0");
            Constructor constructor=clazz.getConstructor(KInvocationHandler.class);
            return  constructor.newInstance(h);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getGetClass(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.java.main.pattern.proxy.jdkproxy.demo2;" + ln);
        sb.append("import com.java.main.pattern.proxy.jdkproxy.demo.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("KInvocationHandler h;" + ln);
        sb.append("public $proxy0(KInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " +  paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("@Override" + ln);
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
