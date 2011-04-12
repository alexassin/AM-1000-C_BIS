package ru.utorus.am.src.bis;


import ru.utorus.am.src.general.*;


public class PerformerKOM implements Performer {
    private TypeS type;
    private State state = State.initialization;
    private Master master;
    private DispatcherKOM dispatcher;
    private TargetSubsystem targetSubsystem;

    public PerformerKOM(Master mMaster, DispatcherKOM mDispatcher) {
        master = mMaster;
        dispatcher = mDispatcher;
        type = typeDetect();
        targetSubsystem = new TargetSubsystem();
    }

    private TypeS typeDetect() {
        return TypeS.KIS;
    }

    public void deConfigure() {
        targetSubsystem.deConfigure();
    }

    public void configure(ConfigurationData config) {
        targetSubsystem.configure(config);
    }

    public void execute(TargetMessage targetMessage) {
        targetSubsystem.execute(targetMessage);
    }

    public class TargetSubsystem implements Performer {

        public void deConfigure() {
        }

        public void configure(ConfigurationData config) {
        }

        public void execute(TargetMessage targetMessage) {
        }
    }

}
