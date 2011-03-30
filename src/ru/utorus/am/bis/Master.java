package ru.utorus.am.bis;

import ru.utorus.am.general.Performer;
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

    private final Dispatcher dispatcher;
    private final Performer performer;
    private static final String CONFIGURE_COMMAND = "1";
    private static final String DECONFIGURE_COMMAND = "2";

    public Master(final Dispatcher dispatcher, final Performer performer) {
        this.dispatcher = dispatcher;
        this.performer = performer;
    }

    public void execute(final Word command) {
        String commandStr = command.getWord();
        if (commandStr.substring(1).equals(CONFIGURE_COMMAND)) {
            performer.configure(new Word(commandStr.substring(1, commandStr.length())));
        } else if (commandStr.substring(1).equals(DECONFIGURE_COMMAND)) {
            performer.deConfigure();
        }
    }

    @Override
    protected void send(final Word wrd) {
        if (dispatcher != null && wrd != null) {
            dispatcher.sendServiceSignal(wrd);
        }
    }
}
