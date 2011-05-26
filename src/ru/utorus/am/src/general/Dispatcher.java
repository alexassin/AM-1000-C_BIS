package ru.utorus.am.src.general;

import ru.utorus.am.src.other.Word;

public interface Dispatcher {
    void sendServiceSignal(Word serviceSignal);

    void sendTargetSignal(Word targetSignal);
}
