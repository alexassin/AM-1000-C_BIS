package ru.utorus.am.src.as;

import ru.utorus.am.src.general.*;
import ru.utorus.am.src.general.Character;

public class MasterAS implements Master{

	private HeartBeat heartBeat;
	private DispatcherAS dispatcher;
	private Performer performer;
	private HeartBeat.B_Timer timer;

	public MasterAS() {
		heartBeat = new HeartBeat();
		dispatcher = null;
		timer = heartBeat.new B_Timer(2000, heartBeat);
		timer.start();
	}

    public void update(Character characterization) {
		heartBeat.process(characterization);
	}

	public void setDispatcher(DispatcherAS dispatcher) {
		this.dispatcher = dispatcher;
	}

	public void setPerformer(Performer as) {
		this.performer = as;
	}

	public void execute(Word wrd) {
		String command = wrd.getWord();
		if (command.contains("configure")) {
			performer.configure(new ConfigurationData(wrd.getWord().substring(9,
					wrd.getWord().length())));
		}
		if (command.contains("deconfigure")) {
			performer.deConfigure();
		}
	}

	class HeartBeat {
		Word character = new Word("");

		public HeartBeat() {
			character.setWord(State.initialization.name());
		}

		public void send() {
			if (dispatcher != null) {
				dispatcher.sendServiceSignal(character);
			}
		}

		public void process(Character characterization) {
			String word = characterization.getCharacter();
			character = new Word(word);
			this.send();
		}

		class B_Timer extends Thread {
			private HeartBeat heartBeat;
			private int interval;

			public B_Timer(int interval, HeartBeat heartBeat) {
				this.interval = interval;
				this.heartBeat = heartBeat;
			}

			public void work() {
				this.run();
			}

			@Override
			public void run() {
				while (true) {
					heartBeat.send();
					try {
						sleep(interval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
