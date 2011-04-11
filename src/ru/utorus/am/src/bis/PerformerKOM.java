package ru.utorus.am.src.bis;


import ru.utorus.am.src.general.Performer;
import ru.utorus.am.src.general.State;
import ru.utorus.am.src.general.TypeS;
import ru.utorus.am.src.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class PerformerKOM implements Performer {
    private TypeS type;
    private State state = State.initialization;
    private Master master;
    private Dispatcher dispatcher;
    private TargetSubsystem targetSubsystem = new TargetSubsystem();
    private SubNetwork subNetwork;
    private ControllerConfiguration controllerConfiguration = new ControllerConfiguration();

    public PerformerKOM(Master mMaster, Dispatcher mDispatcher) {
        master = mMaster;
        dispatcher = mDispatcher;
        type = typeDetect();
    }

    private TypeS typeDetect() {
        return TypeS.KIS;
    }

    public void deConfigure() {
        targetSubsystem.deConfigure();
    }

    public void configure(Word config) {
        //targetSubsystem.configure();
    }

    public void execute(Word targetMessage) {
        targetSubsystem.execute(targetMessage);
    }

    public class TargetSubsystem implements Performer {

        public void deConfigure() {
        }

        public void configure(Word config) {
        }

        public void execute(Word targetMessage) {
        }
    }

    public static class SubNetwork implements Performer {

        public void deConfigure() {
        }

        public void configure(Word config) {
        }

        public void execute(Word targetMessage) {
        }
    }

    public static class ControllerConfiguration {
    }
}
