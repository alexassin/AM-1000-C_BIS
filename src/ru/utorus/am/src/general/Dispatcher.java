package ru.utorus.am.src.general;


public interface Dispatcher {
    void sendServiceSignal(Word serviceSignal);

    void sendTargetSignal(Word targetSignal);
}
