package ru.utorus.am.src.timemanagement;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 04.04.11
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class Clock {
    private Long time;
    private Timer timer;
    private final int ONE_SECOND = 1000;

    public Clock() {
        time = Calendar.getInstance().getTime().getTime();
        timer = new Timer();
        TimerTask heartbeatTask = new TimerTask() {

            @Override
            public void run() {
                time++;
            }
        };

        timer.schedule(heartbeatTask, ONE_SECOND,ONE_SECOND);
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}

