package cz.educanet.web;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class CounterManager implements Serializable {

    public CounterManager() {
    }

    private int count;

    public CounterManager(int count) {
        this.count = count;
    }

    public int getCounter() {
        return count;
    }

    public int add() {
        return count+1;
    }
}
