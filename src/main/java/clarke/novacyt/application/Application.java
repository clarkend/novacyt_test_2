package clarke.novacyt.application;

import clarke.novacyt.application.view.ApplicationFrame;

import javax.swing.*;

/**
 * Runs the Reader Application
 *
 */
public class Application {

    public static void main(String [] args){
        SwingUtilities.invokeLater(ApplicationFrame::new);
    }
}
