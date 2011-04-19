package ru.utorus.am.src.timemanagement;

import ru.utorus.am.src.bis.DispatcherKOM;
import ru.utorus.am.src.general.TimerUser;


public class Synchronizer extends TimerUser {

    private Clock clock;
    private DispatcherKOM dispatcher;
    private final int SYNCHRONIZER_GUID = 2028;

    public Synchronizer(DispatcherKOM dispatcher) {
        this.dispatcher = dispatcher;
        clock = new Clock();
        Timer timer = new Timer(10);
        timer.startTimer();
    }

    @Override
    protected void execute() {
        dispatcher.sendServiceSignal(new Word(SYNCHRONIZER_GUID + clock.getTime().toString()));
    }

    public void process(Word wrd) {
        clock.setTime(Long.valueOf(wrd.getWord()));
    }
}
