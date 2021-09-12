package clarke.novacyt.application.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JarFileUtils {

    private static JarFileUtils instance;

    private static final String CLASS_IN_JAR = "com.novacyt.interview.InstrumentSim";
    private static final String METHOD_IN_JAR_TO_INVOKE = "getReading";

    private static Method methodToInvoke;
    private static Object classToInvoke;

    private String filePath;

    private JarFileUtils(){}

    public static JarFileUtils getInstance(){
        if(instance == null){
            instance = new JarFileUtils();
        }
        return instance;
    }

    private Method loadJar() {
        try {
            ClassLoader classLoader = new URLClassLoader(new URL [] {new URL("file://"+filePath)});
            Class<?> clazz = classLoader.loadClass(CLASS_IN_JAR);
            classToInvoke = clazz.getDeclaredConstructor().newInstance();
            return clazz.getMethod(METHOD_IN_JAR_TO_INVOKE);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Method getMethodToInvoke() {
        return methodToInvoke;
    }

    public Object getClassToInvoke() {
        return classToInvoke;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        methodToInvoke = loadJar();
    }
}
