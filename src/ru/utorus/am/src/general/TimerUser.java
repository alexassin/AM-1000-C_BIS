package ru.utorus.am.src.general;

import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 29.03.11
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class TimerUser {
    protected class Timer extends Thread {
        int interval;
        private java.util.Timer timer;
        private TimerTask heartbeatTask;

        public Timer(int interval) {
            this.interval = interval;
        }

        public void startTimer() {
            timer = new java.util.Timer();
            heartbeatTask = new TimerTask() {

                @Override
                public void run() {
                    execute();
                    System.out.println("test");
                }
            };
            timer.schedule(heartbeatTask, interval, interval);

        }

        public void stopTimer() {
            timer.cancel();
        }
    }

    protected abstract void execute();

}
