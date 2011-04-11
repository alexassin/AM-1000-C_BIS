package ru.utorus.am.src.bis;

import ru.utorus.am.src.general.*;
import ru.utorus.am.src.general.Character;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class MasterKOM extends Pulser implements ru.utorus.am.src.general.Master {

    private final DispatcherKOM dispatcher;
    private final Performer performer;


    public MasterKOM(final DispatcherKOM dispatcher, final Performer performer) {
        this.dispatcher = dispatcher;
        this.performer = performer;
    }

    public void execute(final Word command) {
        String commandStr = command.getWord();
        if (commandStr.substring(1).equals(CONFIGURE_COMMAND)) {
            performer.configure(new ConfigurationData(commandStr.substring(1, commandStr.length())));
        } else if (commandStr.substring(1).equals(DECONFIGURE_COMMAND)) {
            performer.deConfigure();
        }
    }


    public void update(Character character) {
        heartBeat.process(new Word(character.getCharacter()));
    }

    @Override
    protected void send(final Word wrd) {
        if (dispatcher != null && wrd != null) {
            dispatcher.sendServiceSignal(wrd);
        }
    }
}
