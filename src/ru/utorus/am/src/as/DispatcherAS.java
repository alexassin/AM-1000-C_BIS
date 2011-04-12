package ru.utorus.am.src.as;

import ru.utorus.am.src.general.*;

public class DispatcherAS implements Dispatcher{
	private Master master;

	private Integer nodeNumber;

	private BDriver bdriver;

	private Performer as;

	private TransportService transportService;

	public DispatcherAS(int nodeNumber) {
		this.nodeNumber = nodeNumber;
		transportService = new TransportService();
		bdriver = new BDriver();
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public void setAS(Performer as) {
		this.as = as;
	}

	public void sendServiceSignal(Word wrd) {
		String signal = wrd.getWord() + " " + nodeNumber;
		wrd.setWord(signal);
		bdriver.send(wrd);
	}

	public void sendTargetSignal(Word targetMessage) {
		bdriver.send(targetMessage);
	}

	class TransportService {
		public void processSS(Word wrd) {
			String signal = wrd.getWord();
			if (signal.contains(String.valueOf(nodeNumber))) {
				master.execute(wrd);
			}
		}
	}

	class BDriver {
		private String signal;

		public void send(Word wrd) {
			this.signal = wrd.getWord();
			System.out.println(signal);
		}

		public void accept(String str) {
			Word wrd = new Word(str);
			if (str.startsWith("2026")) {
				as.execute(new TargetMessage(str));
			} else {
				transportService.processSS(wrd);
			}
		}
	}
}
