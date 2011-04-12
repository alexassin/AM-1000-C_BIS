package ru.utorus.am.src.general;


public interface Performer {
    void deConfigure();

    void configure(ConfigurationData config);

    void execute(TargetMessage targetMessage);

}
