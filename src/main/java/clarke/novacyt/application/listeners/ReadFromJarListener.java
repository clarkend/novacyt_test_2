package clarke.novacyt.application.listeners;

import clarke.novacyt.application.utils.JarFileUtils;
import clarke.novacyt.application.view.ApplicationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReadFromJarListener implements ActionListener {
    private final ApplicationFrame application;
    private SwingWorker<Boolean, String> backgroundThread;

    public ReadFromJarListener(ApplicationFrame application) {
        this.application = application;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (backgroundThread != null && !backgroundThread.isCancelled()) {
            backgroundThread.cancel(true);
        } else {
            backgroundThread = new SwingWorker<>() {
                @Override
                protected Boolean doInBackground() throws Exception {
                    JarFileUtils instance = JarFileUtils.getInstance();
                    Object clazz = instance.getClassToInvoke();
                    if(clazz != null) {
                        publish("Program starting");
                        while (!backgroundThread.isCancelled()) {
                            String reading = String.valueOf(instance.getMethodToInvoke().invoke(clazz));
                            publish(reading);
                        }
                    } else {
                        backgroundThread.cancel(true);
                        publish("Please load a Jar file to take the readings.");
                      }
                    return true;
                }

                @Override
                protected void process(List<String> chunks) {
                    for (String line : chunks) {
                        application.getOutputTextArea().append(line);
                        application.getOutputTextArea().append("\n");
                    }
                }

                @Override
                protected void done() {
                    super.done();
                    String message = "Finished";
                    if(backgroundThread.isCancelled()){
                        message = "Stopped/Paused";
                    }
                    publish(message);
                }
            };
            backgroundThread.execute();
        }
    }
}