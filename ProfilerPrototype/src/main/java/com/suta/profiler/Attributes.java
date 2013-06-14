package com.suta.profiler;


import com.suta.profiler.types.ProfilingLevel;
import com.suta.profiler.types.ProfilingScenario;
import com.suta.profiler.types.ProjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *  This class contains all attributes, that are used in this project,
 *  they may or may not be changed by user in user gui
 *
 *  @author Erik Suta
 *
 * TODO - methods, that will create the file structure, if it is not existing
 * */
public class Attributes {

    /* GUI ATTRIBUTES FOR PROFILING */
    /* Attributes */
    public static ProjectType currentProject = null;
    public static ProfilingScenario currentProfilingScenario = null;
    public static ProfilingLevel currentProfilingLevel = null;

    /* OTHER ATTRIBUTES */
    public static String COMMON_FILE_PATH_ABSOLUTE = "C:\\Profiler";
    public static String OBJECTS_FILE_PATH = COMMON_FILE_PATH_ABSOLUTE + "\\Objects";

    public static String AGENT_FILE_PATH = COMMON_FILE_PATH_ABSOLUTE + "\\agent\\agent.jar";

    public static String PROJECT_FILE_PATH = OBJECTS_FILE_PATH + "\\Projects";
    public static String PROFILING_SCENARIO_FILE_PATH = OBJECTS_FILE_PATH + "\\Scenarios";
    public static String PROFILING_LEVEL_FILE_PATH = OBJECTS_FILE_PATH + "\\Levels";
    public static String PROFILING_JAR_FILE_PATH = COMMON_FILE_PATH_ABSOLUTE + "\\jar\\";

    public static String TEMP_FILE_PATH = COMMON_FILE_PATH_ABSOLUTE + "\\temp\\";

    public static List<String> OBJECT_METHODS = Arrays.asList("wait","equals", "toString", "hashCode", "getClass", "notify", "notifyAll");

    public static Integer PROFILING_PORT = 22558;
    public static Integer COMMAND_FIELD_MAX_SIZE = 3;

    /* PACKET MESSAGES */
    public static String PROFILING_PACKET_MESSAGE_TERMINATE = "TERMINATE";
    public static String PROFILING_PACKET_MESSAGE_INSTRUCTION = "INST";
}
