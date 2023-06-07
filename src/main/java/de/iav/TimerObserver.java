package de.iav;

public class TimerObserver implements Observer{
    @Override
    public void handleUpdate(String s) {
        System.out.println("TimerObserver[" + this.toString() + "]: time = " + s);
    }
}
