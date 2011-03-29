package ru.utorus.am.bis;


import ru.utorus.am.general.Performer;
import ru.utorus.am.general.State;
import ru.utorus.am.general.TypeS;
import ru.utorus.am.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class PerformerKOM implements Performer {
    private TypeS type;
    private State state;

    public PerformerKOM() {
        state = State.initialization;
    }

    public void deConfigure() {
    }

    public void configure(Word config) {
    }

    public void execute(Word targetMessage) {
    }
}
