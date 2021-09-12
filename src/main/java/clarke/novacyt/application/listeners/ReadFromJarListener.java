package clarke.novacyt.application.listeners;

import clarke.novacyt.application.model.Readings;
import clarke.novacyt.application.threads.ApplicationExecutor;
import clarke.novacyt.application.threads.GetReadingTask;
import clarke.novacyt.application.view.ApplicationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadFromJarListener implements ActionListener {
    private final SwingWorker<Boolean, Readings> backgroundThread;

    public ReadFromJarListener(ApplicationFrame application, ApplicationExecutor executor) {
        backgroundThread = new GetReadingTask(application, executor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        backgroundThread.execute();
    }
}