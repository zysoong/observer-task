package de.iav;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Timer implements Subject{

    private double time;
    private boolean stopFlag;
    private Lock lock;
    private List<Observer> observerList;

    public Timer(){
        this.time = 0.;
        this.observerList = new ArrayList<>();
        this.stopFlag = false;
        this.lock = new ReentrantLock();
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

        this.lock.lock();

        while(true){

            if (this.stopFlag) {
                break;
            }

            Thread.sleep(1000);
            this.time += 1;
            notifyObservers();
        }

        this.lock.unlock();
    }

    public void stop() throws InterruptedException {
        //this.lock.lock();
        this.time = 0;
        notifyObservers();
        this.stopFlag = true;
        //this.lock.unlock();
    }
}
