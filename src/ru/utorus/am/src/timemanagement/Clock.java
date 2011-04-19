package ru.utorus.am.src.timemanagement;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class Clock {
    private Long time;

    public Clock() {
        time = Calendar.getInstance().getTime().getTime();
        Timer timer = new Timer();
        TimerTask heartbeatTask = new TimerTask() {

            @Override
            public void run() {
                time++;
            }
        };

        int ONE_SECOND = 1000;
        timer.schedule(heartbeatTask, ONE_SECOND,ONE_SECOND);
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}

