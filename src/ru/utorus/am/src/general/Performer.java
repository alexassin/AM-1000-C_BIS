package ru.utorus.am.src.general;


public interface Performer {
    void deConfigure();

    void configure(Word config);

    void execute(TargetMessage targetMessage);

}
