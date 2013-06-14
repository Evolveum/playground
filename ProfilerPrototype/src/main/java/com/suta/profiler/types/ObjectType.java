package com.suta.profiler.types;

import com.suta.profiler.Attributes;
import com.suta.profiler.gui.util.ProfilingPage;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class is a parent class of all types used in this project.
 *
 *  @author Erik Suta
 * */
public class ObjectType implements Serializable {

    /* Attributes */
    //static Logger LOGGER = ProfilingPage.LOGGER;

    /**
     *  TODO
     *  This method is here just for now, it is for object serialization. It
     *  will soon be replaced with xml serialization
     * */
    public static void serializeObject(ObjectType object, String path, String name){

        try{
            FileOutputStream fileOut = new FileOutputStream(path + "\\" + name + ".prj");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        }catch (IOException e){
            //e.printStackTrace();
            //LOGGER.error("Problem with serialization of object to file: " + path + "\\" + name + ".prj: " + e.getStackTrace().toString());
            //TODO - log, if error
        }

    }

    /**
     *  TODO
     *  This method is used for object deserialization. It will soon be
     *  replaced with wml serialization
     * */
    public static ObjectType deserializeObject(String path, String name){

        ObjectType object = null;

        try{
            FileInputStream fileIn = new FileInputStream(path + "\\" + name);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = (ObjectType)in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException ioe){
            //ioe.printStackTrace();
            //LOGGER.error("Problem with deserialization of object to file: " + path + "\\" + name + ".prj: " + ioe.getStackTrace().toString());
            //TODO - log, if error
        }
        catch (ClassNotFoundException cnfe){
            //cnfe.printStackTrace();
           //LOGGER.error("Problem with serialization of object to file, missing object class: " + path + "\\" + name + ".prj: " + cnfe.getStackTrace().toString());
            //TODO - Log, if error
        }

        return object;
    }

    /**
     *  TODO
     *
     *  Delete provided object
     * */
    public static void deleteObject(String dir, String fileName){
        File file = new File(dir + "\\" + fileName + ".prj");

        if(file.delete()){
            //TODO - log, that file was deleted correctly
            //LOGGER.info("File: " + file.getAbsolutePath() + " was deleted succesfully");
            System.out.println("File: " + dir + "\\" + fileName + ".prj was deleted correctly");
        }else{
            //TODO - Log, that file was not deleted correctly
            //LOGGER.warn("File: " + file.getAbsolutePath() + " was NOT deleted succesfully");
            System.out.println("File: " + dir + "\\" + fileName + ".prj was NOT deleted correctly");
        }

    }

    /**
     *  TODO
     *
     *  read all objects of specified type from disk
     * */
    public static List<ObjectType> getAllObjects(String folder){
        List<ObjectType> objectList = new ArrayList<ObjectType>();
        File directory = new File(folder);

        File[] fileList = directory.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".prj");
            }
        });

        for(File f: fileList){
            //System.out.println("Path: " + f.getAbsolutePath());
            objectList.add(deserializeObject(folder, f.getName()));
        }

        return objectList;
    }   //getAllObjects end


}
