package ru.utorus.am.src.general;

import ru.utorus.am.src.other.Word;

public interface Performer {
    void deConfigure();

    void configure(Word config);

    void execute(Word targetMessage);

}
