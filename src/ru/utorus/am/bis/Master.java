package ru.utorus.am.bis;

import ru.utorus.am.general.Pulser;
import ru.utorus.am.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class Master extends Pulser {

    private Dispatcher dispatcher;

    public void execute(String substring) {
    }

    @Override
    protected void send(Word wrd) {
        if (dispatcher != null && wrd != null) {
            dispatcher.sendServiceSignal(wrd);
        }
    }
}
