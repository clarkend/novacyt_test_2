package clarke.novacyt.application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Readings {

    private static ConcurrentLinkedQueue<String> readings;

    public Readings(){
        readings = new ConcurrentLinkedQueue<>();
    }

    public ConcurrentLinkedQueue<String> getReadings() {
        return readings;
    }

}
