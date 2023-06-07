package de.iav;

import java.util.ArrayList;
import java.util.List;

public class Timer implements Subject{

    private double time;
    private List<Observer> observerList;

    public Timer(){
        this.time = 0.;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : this.observerList){
            o.handleUpdate(this.time + "");
        }
    }

    public void start() throws InterruptedException {
        while(true){
            Thread.sleep(1000);
            this.time += 1;
            notifyObservers();
        }
    }

    public void stop() throws InterruptedException {
        this.time = 0;
        notifyObservers();
    }
}
