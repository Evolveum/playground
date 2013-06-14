package com.suta.profiler.util;

import com.suta.profiler.Attributes;
import com.suta.profiler.types.ProjectType;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import sun.jdbc.odbc.ee.ObjectPool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 *  JarFileHandler is a class, that handles all activity with jarFiles, from loading
 *  .jar file from user to GUI, to it's search and extraction of class Files.
 *  We also perform method extraction from found class files here.
 *
 *  @author Erik Suta
 * */
public class JarFileHandler {

    /* Attributes */
    private static final Class[] parameters = new Class[] { URL.class };

    /**
     *  Mwthod creates new file in profiler system folder
     */
    public static String loadAndStoreJarFile(FileUpload uploadedFile){
        File newFile = null;

        if(uploadedFile != null){
            newFile = new File(Attributes.PROFILING_JAR_FILE_PATH + uploadedFile.getClientFileName());

            if(newFile.exists())
                newFile.delete();

            try{
                newFile.createNewFile();
                uploadedFile.writeTo(newFile);

            }catch(IOException e){
                e.printStackTrace();
                throw new IllegalStateException("Error: " + e.getMessage(), e);
                //TODO - log error + throw better Illegal State Exception
        }
        }else {
            throw new IllegalStateException("Error");
        }

        return newFile.getAbsolutePath();
    }   //method end

    /**
     *  This method is responsible for discovery of provided .jar File, from which we will get
     *  all classes and all their methods.
     *
     *  First, we read all entries from jar file, and if they're .class files, we copy them
     *  to temp profiler folder
     * */
    public static void runJarDiscovery(ProjectType project){
        String jarFileName = project.getJarPath();
        File jarFile = new File(jarFileName);

        try{
            JarFile jar = new JarFile(jarFile);

            URLClassLoader sysLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
            Class sysClass = URLClassLoader.class;
            Method method = sysClass.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(sysLoader, new Object[]{jarFile.toURL()});

            Enumeration<JarEntry> enumeration = jar.entries();


            while(enumeration.hasMoreElements()){
                JarEntry jarEntry = enumeration.nextElement();

                String jarEntryName = jarEntry.getName();
                if(jarEntryName.endsWith(".class")){
                    String className = jarEntryName.replace('/', '.').substring(0, jarEntryName.length() - 6);

                    Class<?> c = Class.forName(className);

                    extractMethods(c, project);
                }
            }
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //TODO - log error and write better exception solution
        }catch (IOException ioe){
            ioe.printStackTrace();
            //TODO - log error and write better exception solution
        }catch (NoSuchMethodException nsme){
            nsme.printStackTrace();
            //TODO - log error and write better exception solution
        }catch (IllegalAccessException iae){
            iae.printStackTrace();
            //TODO - log error and write better exception solution
        }catch (InvocationTargetException ite){
            ite.printStackTrace();
            //TODO - log error and write better exception solution
        }
    }

    /**
     *  This function creates Class object from provided file and extracts
     *  all methods implemented in .class file
     * */
    public static void extractMethods(Class<?> c, ProjectType project){
        Method[] methodField = c.getMethods();

        ArrayList<String> tempList = new ArrayList<String>();
        for(Method m: methodField){
            tempList.add(m.getName());
            //System.out.println("Class: " + c.getName() + ", Method: " + m.getName());
        }
        project.getMethodMultiMap().put(c.getName(), tempList);


    }



}