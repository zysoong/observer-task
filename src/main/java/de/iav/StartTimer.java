package de.iav;

import java.util.concurrent.locks.Lock;

public class StartTimer implements Runnable{

    private Timer timer;

    public StartTimer(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            this.timer.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
