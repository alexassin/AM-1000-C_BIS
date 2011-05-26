package ru.utorus.am.src.general;

import ru.utorus.am.src.other.Word;

public abstract class Pulser {
    protected HeartBeat heartBeat;

    public Pulser() {
        heartBeat = new HeartBeat();
    }

    protected class HeartBeat extends TimerUser {

        private Word character;

        @Override
        protected void execute() {
            send(character);
        }

        public void process(final Word wrd) {
            this.character = wrd;
        }
    }


    protected abstract void send(final Word wrd);
}
