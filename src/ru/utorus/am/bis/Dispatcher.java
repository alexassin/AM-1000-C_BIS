package ru.utorus.am.bis;

import ru.utorus.am.general.Driver;
import ru.utorus.am.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 29.03.11
 * Time: 8:41
 * To change this template use File | Settings | File Templates.
 */
public class Dispatcher {
    private final Driver driver;
    private int nodeId;

    public Dispatcher(final Driver driver, int nodeId) {
        this.driver = driver;
        this.nodeId = nodeId;
    }

    public void sendServiceSignal(final Word serviceSignal) {
        StringBuffer service = new StringBuffer(serviceSignal.getWord());
        StringBuffer signal = new StringBuffer(service.substring(4))
                .append(nodeId)
                .append(service
                        .substring(4, service.length()));
        serviceSignal.setWord(signal.toString());
        driver.send(serviceSignal);
    }

    public void sendTargetSignal(final Word targetSignal) {
        driver.send(targetSignal);
    }
}
