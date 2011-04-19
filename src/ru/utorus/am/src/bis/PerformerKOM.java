package ru.utorus.am.src.bis;


import ru.utorus.am.src.general.Performer;
import ru.utorus.am.src.general.State;
import ru.utorus.am.src.general.TypeS;
import ru.utorus.am.src.general.Master;
import ru.utorus.am.src.general.Dispatcher;
import ru.utorus.am.src.general.Word;


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
        if (type.equals(TypeS.KIS) && type.equals(TypeS.KIT)) {
            subNetwork = new BNetwork();
        }
        if (type.equals(TypeS.KOS) && type.equals(TypeS.KOL)) {
            subNetwork = new SNetwork();
        }
    }

    private TypeS typeDetect() {
        return TypeS.KIS;
    }

    public void deConfigure() {
        targetSubsystem.deConfigure();
        subNetwork.deConfigure();
        controllerConfiguration.deConfigure();
    }

    public void configure(Word config) {

        targetSubsystem.configure();
        subNetwork.configure();
        controllerConfiguration.configure();
    }

    public void execute(Word targetMessage) {
        targetSubsystem.execute(targetMessage);
        subNetwork.execute(targetMessage);
    }

    public class TargetSubsystem implements Performer {

        public void deConfigure() {
        }

        public void configure(Word config) {
        }

        public void execute(Word targetMessage) {
        }
    }

    public abstract class SubNetwork implements Performer {

        public abstract void deConfigure();

        public abstract void configure(Word config);

        public abstract void execute(Word targetMessage);
    }

    public class BNetwork extends SubNetwork {

        public void deConfigure() {

        }

        public void configure(Word config) {

        }

        public void execute(Word targetMessage) {
        }
    }

    public class SNetwork extends SubNetwork {

        public void deConfigure() {
        }

        public void configure(Word config) {
        }

        public void execute(Word targetMessage) {
        }
    }


    public class ControllerConfiguration {

        public void deConfigure() {
        }

        public void configure(Word config) {
        }

        public void execute(Word targetMessage) {
        }
    }
}
