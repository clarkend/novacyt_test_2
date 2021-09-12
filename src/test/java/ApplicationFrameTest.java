import clarke.novacyt.application.view.ApplicationFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ApplicationFrameTest {

    private ApplicationFrame frame;

    @Before
    public void setUp(){
        if(this.frame == null){
            this.frame = new ApplicationFrame();
            this.frame.setVisible(false);
        }
    }

    @After
    public void tearDown(){
        if(this.frame != null){
            this.frame.dispose();
            this.frame = null;
        }
    }

    @Test
    public void testATextAreaInitialisationDefaults(){
        JTextArea testTextArea = this.frame.getOutputTextArea();
        assertNotNull(testTextArea);
        assertEquals(testTextArea.getText(), "");
        assertFalse(testTextArea.isEditable());
    }

}
