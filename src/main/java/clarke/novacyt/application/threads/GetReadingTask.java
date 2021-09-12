package clarke.novacyt.application.threads;

import clarke.novacyt.application.model.Readings;
import clarke.novacyt.application.view.ApplicationFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class GetReadingTask extends SwingWorker<Boolean, Readings> {

    private final ApplicationFrame application;
    private final ApplicationExecutor executor;

    public GetReadingTask(ApplicationFrame application, ApplicationExecutor executor) {
        this.application = application;
        this.executor = executor;
    }

    @Override
    protected Boolean doInBackground() throws ExecutionException, InterruptedException {
        LoadReadingCallableTask task = new LoadReadingCallableTask();
        Queue<Future<Readings>> taskQueue = new LinkedList<>();

        for(int i = 0; i< executor.getCapacity(); i++){
            taskQueue.add(executor.getExecutorService().submit(task));
    //        System.out.println("Task Queue Size :"+taskQueue.size());
        }

        while(!taskQueue.isEmpty()){
            Future<Readings> result = taskQueue.remove();
            System.out.println("Task Queue Size :"+taskQueue.size());
            publish(result.get());
        }
        return true;
    }

    @Override
    protected void process(List<Readings> chunks) {
        super.process(chunks);
   //     System.out.println("Chunk Size :"+chunks.size());
        StringBuilder sb = new StringBuilder();
        for(Readings r: chunks){
            for(String s: r.getReadings()){
                sb.append(s).append("\n");
            }
        }
            application.getOutputTextArea().setText(sb.toString());

//        chunks.forEach(chunk -> {
//            sb.append(chunk).append("\n");
//       //     System.out.println("Chunk :"+chunk);
//        });
//        application.getOutputTextArea().setText(sb.toString());
    }

    @Override
    protected void done() {
        super.done();
      //  Readings r = new Readings();
      //  r.getReadings().add("Done");
      //  r.getReadings().add("Size: "+r.getReadings().size());
       // publish(new ArrayList(Arrays.asList(r.getReadings())));

       // publish(r.getReadings().remove());
    }
}

