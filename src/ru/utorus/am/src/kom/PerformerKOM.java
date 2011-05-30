package ru.utorus.am.src.kom;


import ru.utorus.am.src.general.*;
import ru.utorus.am.src.other.Word;


public class PerformerKOM implements Performer {
    private TypeS type;
    private State state = State.initialization;
    private Master master;
    private Dispatcher dispatcher;
    private TargetSubsystem targetSubsystem = new TargetSubsystem();
    private Performer subNetwork;
    private ControllerConfiguration controllerConfiguration = new ControllerConfiguration();

    public PerformerKOM(Master mMaster, Dispatcher mDispatcher) {
        master = mMaster;
        dispatcher = mDispatcher;
        type = typeDetect();
        if (type.equals(TypeS.KIS)) {
            subNetwork = new BisNetwork();
        }
        if (type.equals(TypeS.KIT)) {
            subNetwork = new BitNetwork();
        }
        if (type.equals(TypeS.KOS) && type.equals(TypeS.KOL)) {
            subNetwork = new SNetwork();
        }
        if (controllerConfiguration.isConfiguration()) {
            state = State.configured;
            configure(controllerConfiguration.configuration());
        } else {
            state = State.deconfigured;
        }
    }

    private TypeS typeDetect() {
        return TypeS.KIS;
        //return TypeS.KOS;
        //return TypeS.KIT;
        //return TypeS.KOL;
    }

    public void deConfigure() {
        targetSubsystem.deConfigure();
        subNetwork.deConfigure();
        controllerConfiguration.deConfigure();
    }

    public void configure(Word config) {
        Word tsConfig = config;
        Word snConfig = config;
        targetSubsystem.configure(tsConfig);
        subNetwork.configure(snConfig);
        controllerConfiguration.configure(config);
    }

    public void execute(Word targetMessage) {
        targetSubsystem.execute(targetMessage);
        subNetwork.execute(targetMessage);
    }

    public class TargetSubsystem implements Performer {
        private TargetTask targetTask;

        public void deConfigure() {
            targetTask = null;
        }

        public void configure(Word config) {
            targetTask = new TargetTask();
        }

        public void execute(Word targetMessage) {
            targetTask.execute(targetMessage);
        }

        public class TargetTask {
            public void execute(Word targetMessage) {
                System.out.println(targetMessage);
            }
        }
    }

    public class BisNetwork implements Performer {
        private final int numberMasterAS = 20;
        private MasterAS masterAS[] = new MasterAS[numberMasterAS];

        public void deConfigure() {
            for (int ii = 0; ii < numberMasterAS; ii++)
                masterAS[ii].deConfigure();
        }

        public void configure(Word config) {
            for (int ii = 0; ii < numberMasterAS; ii++)
                masterAS[ii].configure(config);
        }

        public void execute(Word targetMessage) {
        }

        public class MasterAS extends Pulser {
            private AgentAS agentAS;
            private StateMasterAS state = StateMasterAS.inspection;

            public void deConfigure() {
                state = StateMasterAS.inspection;
                agentAS.deConfigure();
            }

            public void configure(Word config) {
                state = StateMasterAS.work;
                agentAS.configure(config);
            }

            protected void send(Word wrd) {

            }

            public class AgentAS {
                int numberSubordinate;
                Dispatcher dispatcher;
                StateAgent stateAgent;

                public void deConfigure() {

                }

                public void configure(Word config) {

                }
            }
        }

        public class DispatcherBIS implements Dispatcher {

            public void sendServiceSignal(Word serviceSignal) {

            }

            public void sendTargetSignal(Word targetSignal) {

            }
        }
    }

    public class BitNetwork implements Performer {

        public void deConfigure() {

        }

        public void configure(Word config) {

        }

        public void execute(Word targetMessage) {
        }
    }

    public class SNetwork implements Performer {

        public void deConfigure() {
        }

        public void configure(Word config) {
        }

        public void execute(Word targetMessage) {
        }
    }


    public class ControllerConfiguration {
        private Word config;

        public void deConfigure() {
            config = null;
        }

        public void configure(Word mConfig) {
            config = mConfig;
        }

        public Word configuration() {
            return config;
        }

        public boolean isConfiguration() {
            return (!(config == null));
        }
    }
}
