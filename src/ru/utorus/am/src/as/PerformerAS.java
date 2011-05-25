package ru.utorus.am.src.as;

import ru.utorus.am.src.general.*;
import ru.utorus.am.src.general.Character;

public class PerformerAS implements Performer{

    private TargetTask targetTask = null;
	private Master master;
	private DispatcherAS dispatcher;
	private State state;
	private TypeAS type;

	public PerformerAS() {
		state = State.initialization;
		type = TypeAS.TYPE_ONE;
	}

	public void setMaster(Master master) {
		this.master = master;
		Character character = new Character(state);
		master.update(character);
		state = State.deconfigured;
        Character disconnetCharacter = new Character(state);
		master.update(disconnetCharacter);
	}

	public void processTS(TargetMessage targetMessage) {
		targetTask.processTS(targetMessage);
	}

	public void setDispathcer(DispatcherAS dispatcher) {
		this.dispatcher = dispatcher;
	}

	public void deConfigure() {
		this.state = State.deconfigured;
		Character character = new Character(state);
		master.update(character);
		if (targetTask != null) {
			targetTask.delete();
			targetTask = null;
		}
	}

    public void execute(TargetMessage targetMessage) {
       if (targetTask != null){
           targetTask.processTS(targetMessage);
       }
    }

    public void configure(Word configurationData) {
		this.state = State.configured;
		targetTask = new TargetTask(configurationData);
	}

    class TargetTask {

		private boolean work;

		public TargetTask(Word configurationData) {
			this.work = true;
		}

		public void processTS(TargetMessage targetMessage) {
			if (work)
				dispatcher.sendTargetSignal(targetMessage);
		}

		public void delete() {
			this.work = false;
		}

	}
}
