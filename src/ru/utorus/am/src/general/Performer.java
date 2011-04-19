package ru.utorus.am.src.general;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 29.03.11
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public interface Performer {
    void deConfigure();

    void configure(ConfigurationData config);

    void execute(TargetMessage targetMessage);

}
