package com.company;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by Admin on 26.08.2016.
 */
public class Main {
        public static void main(String[] args) {
            Class [] param = new Class[]{String.class,int.class,int.class};
            Object[] arguments = new Object[]{new String("String"),new Integer(55), new Integer (66)};
            String curDir = new File("").getAbsolutePath();
            String jarPath = curDir+"\\out\\production\\ReflectiionMain\\com\\company\\";
            classLoader(jarPath,"com.company.FirstClass","init",arguments,param);
            classLoader(jarPath,"com.company.SecondClass","init",arguments,param);


        }

    public static void classLoader (String path,String packageName,String methodName,Object[] args,Class[] param){
        try {
            URL[] urls ={ new URL("file:" + path) };
            URLClassLoader cl = URLClassLoader.newInstance(urls);
            Class<?> clazz = cl.loadClass(packageName);
            Method[] met = clazz.getMethods();

            for (Method method:met){
                int k = method.getParameterCount();

                if (method.getName()==methodName){

                    if (method.getParameterCount()==3){
                        break;
                    }
                    else
                        System.out.println("Invalid parameter count in method.");
                }
                else {
                    System.out.println("Invalid method name or no such method in class.");
                    return;
                }
            }
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod(methodName,param);
            method.invoke(obj,args);

        }
        catch (Exception e){

        }

    }

}
