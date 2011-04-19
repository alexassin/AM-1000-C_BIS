package ru.utorus.am.src.general;


public interface Master {
    static final String CONFIGURE_COMMAND = "1";
    static final String DECONFIGURE_COMMAND = "2";
    void execute(Word command);
    void update(Character character);
}
