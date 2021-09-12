package clarke.novacyt.application.view;

import clarke.novacyt.application.listeners.OpenFileListener;
import clarke.novacyt.application.listeners.ReadFromJarListener;
import clarke.novacyt.application.threads.ApplicationExecutor;

import javax.swing.*;
import java.awt.*;

/**
 * Sets up the Application Window, adds components and associated listeners to the JTextArea, JButtons and JFrame
 *
 */
public class ApplicationFrame extends JFrame {

    private JTextArea outputTextArea;

    public ApplicationFrame(){
        initialiseComponents();
    }

    private void initialiseComponents() {

        JButton fileButton = new JButton("Open File");
        fileButton.addActionListener(new OpenFileListener());

        JButton playButton = new JButton("Start/Stop");
        playButton.addActionListener(new ReadFromJarListener(this, new ApplicationExecutor()));

        outputTextArea = new JTextArea(100, 40);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        this.setLayout(new FlowLayout());
        this.getContentPane().add(fileButton);
        this.getContentPane().add(playButton);
        this.getContentPane().add(scrollPane);
        this.setTitle("Reading Application");
        this.setSize(500, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTextArea getOutputTextArea() {
        return outputTextArea;
    }
}
