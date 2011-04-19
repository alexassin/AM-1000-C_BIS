package ru.utorus.am.src.general;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 11.04.11
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public interface Dispatcher {
    void sendServiceSignal(Word serviceSignal);

    void sendTargetSignal(Word targetSignal);
}
