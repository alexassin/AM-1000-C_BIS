package ru.utorus.am.general;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 29.03.11
 * Time: 8:44
 * To change this template use File | Settings | File Templates.
 */
public abstract class Pulser {
    private HeartBeat heartBeat;

    public Pulser() {
        heartBeat = new HeartBeat();
    }

    protected class HeartBeat extends TimerUser {

        @Override
        protected void execute() {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public void execute(Word wrd) {
        heartBeat.execute();
    }

    protected abstract void send(Word wrd);
}
