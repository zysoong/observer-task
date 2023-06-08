package de.iav;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Timer implements Subject{

    private double time;
    private boolean stopFlag;
    private Semaphore mutex;
    private List<Observer> observerList;

    public Timer(){
        this.time = 0.;
        this.observerList = new ArrayList<>();
        this.stopFlag = false;
        this.mutex = new Semaphore(1);
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

        try {

            this.mutex.acquire();

            while (true) {

                if (this.stopFlag) {
                    break;
                }

                Thread.sleep(1000);
                this.time += 1;
                notifyObservers();
            }

        } finally {
            this.mutex.release();
        }


    }

    public void stop() throws InterruptedException {
        try {
            //this.mutex.acquire();
            this.time = 0;
            notifyObservers();
            this.stopFlag = true;
        } finally {
            //this.mutex.release();
        }
    }
}
