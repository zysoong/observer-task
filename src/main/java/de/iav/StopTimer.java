package de.iav;

public class StopTimer implements Runnable{

    private Timer timer;

    public StopTimer(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            this.timer.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
