package ru.utorus.am.src.general;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 11.04.11
 * Time: 11:46
 * To change this template use File | Settings | File Templates.
 */
public interface Master {
    static final String CONFIGURE_COMMAND = "1";
    static final String DECONFIGURE_COMMAND = "2";
    void execute(Word command);
    void update(Character character);
}
