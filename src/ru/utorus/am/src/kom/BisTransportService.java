package ru.utorus.am.src.kom;

import ru.utorus.am.src.general.Observer;
import ru.utorus.am.src.general.Word;


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
