package clarke.novacyt.application.threads;

import clarke.novacyt.application.model.Readings;
import clarke.novacyt.application.utils.JarFileUtils;

import java.util.concurrent.Callable;

public class LoadReadingCallableTask implements Callable<Readings> {

    private static Readings readings;

    public LoadReadingCallableTask(){
        System.out.println("Constructor");
        readings = new Readings();
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Readings call() throws Exception {
        Object clazz = JarFileUtils.getInstance().getClassToInvoke();
       // System.out.println("Invoking Jar file");

        readings.getReadings().add(String.valueOf(JarFileUtils.getInstance().getMethodToInvoke().invoke(clazz)));
        return readings;
    }
}
