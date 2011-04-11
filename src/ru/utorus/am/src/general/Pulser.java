package ru.utorus.am.src.general;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 29.03.11
 * Time: 8:44
 * To change this template use File | Settings | File Templates.
 */
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
