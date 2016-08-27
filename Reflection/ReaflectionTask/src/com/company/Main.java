package com.company;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.rmi.AccessException;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by Admin on 23.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        String curDir = new File("").getAbsolutePath();
        String jarPath = curDir+"\\out\\production\\ReaflectionTask\\com\\company\\FirstClass.jar";
        try {
            URL[] urls ={ new URL("file:" + jarPath) };
            URLClassLoader cl = URLClassLoader.newInstance(urls);
            Class<?> clazz ;
            clazz = cl.loadClass("com.company.FirstClass");
            Object obj = clazz.newInstance();
            FirstClass first = (FirstClass)obj;
            first.init("Greetings",55,66);
            Method met = clazz.getMethod("init");
            met.invoke(obj);

        }
        catch (ClassNotFoundException e){

        }
        catch (MalformedURLException ex){

        }
        catch (InstantiationException e){

        }
        catch (IllegalAccessException e){

        }
        catch (NoSuchMethodException e){

        }
        catch (InvocationTargetException e){

        }

    }
    public static List getClasseNamesInPackage
            (String jarName, String packageName){
        ArrayList classes = new ArrayList ();

        packageName = packageName.replaceAll("\\." , "/");
        System.out.println ("Jar " + jarName + " looking for " + packageName);
        try{
            JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
            JarEntry jarEntry;

            while(true) {
                jarEntry=jarFile.getNextJarEntry ();
                if(jarEntry == null){
                    break;
                }
                if((jarEntry.getName ().startsWith (packageName)) &&
                        (jarEntry.getName ().endsWith (".class")) ) {
                    System.out.println
                            ("Found " + jarEntry.getName().replaceAll("/", "\\."));
                    classes.add (jarEntry.getName().replaceAll("/", "\\."));
                }
            }
        }
        catch( Exception e){
            e.printStackTrace ();
        }
        return classes;
    }
}
