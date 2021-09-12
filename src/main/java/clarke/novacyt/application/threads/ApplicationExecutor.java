package clarke.novacyt.application.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ApplicationExecutor {

    private static ExecutorService executorService;

    private static final int THREADS = 4;
    private static final int CAPACITY = 20;

    public ApplicationExecutor(){
        executorService = new ThreadPoolExecutor(THREADS, THREADS, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public ExecutorService getExecutorService(){
        return executorService;
    }

    public int getCapacity(){
        return CAPACITY;
    }
}
