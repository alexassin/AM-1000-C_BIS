package ru.utorus.am.src.bis;

import ru.utorus.am.src.general.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class BisTransportService implements Observer {
    private BDriver driver;
    private String serviceMessage = "2026";
    private String configure = "1";
    private String deConfigure = "2";
    private PerformerKOM performer;
    private MasterKOM master;

    BisTransportService(BDriver driver, MasterKOM master, PerformerKOM performer) {
        this.driver = driver;
        this.master = master;
        this.performer = performer;
    }

    public void update() {
        if (driver != null && master != null && performer != null) {
            Word wrd = driver.get();
            String str = wrd.getWord();
            String guid = str.substring(4);
            if (guid.equals(serviceMessage)) {
                master.execute(new Word(str.substring(5, str.length())));
            }
        }
    }
}
