package de.iav;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        TimerObserver timerObserver_0 = new TimerObserver();
        TimerObserver timerObserver_1 = new TimerObserver();
        TimerObserver timerObserver_2 = new TimerObserver();
        TimerObserver timerObserver_3 = new TimerObserver();

        timer.attachObserver(timerObserver_0);
        timer.attachObserver(timerObserver_1);
        timer.attachObserver(timerObserver_2);
        timer.attachObserver(timerObserver_3);

        Thread t1 = new Thread(new StartTimer(timer));
        t1.start();

        Thread.sleep(5000);

        Thread t2 = new Thread(new StopTimer(timer));
        t2.start();

    }


}