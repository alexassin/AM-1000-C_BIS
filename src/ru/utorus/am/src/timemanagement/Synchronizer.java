package ru.utorus.am.src.timemanagement;

import ru.utorus.am.src.bis.Dispatcher;
import ru.utorus.am.src.general.TimerUser;
import ru.utorus.am.src.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 04.04.11
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public class Synchronizer extends TimerUser {

    private Clock clock;
    private Dispatcher dispatcher;
    private final int SYNCHRONIZER_GUID = 2028;

    public Synchronizer(Dispatcher dispatcher) {
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
