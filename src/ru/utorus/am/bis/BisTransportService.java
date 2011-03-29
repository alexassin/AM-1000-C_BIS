package ru.utorus.am.bis;

import ru.utorus.am.general.Observer;
import ru.utorus.am.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
 class BisTransportService implements Observer {
        private BDriver driver;
        private String serviceMessage = "2026";
        private String configure = "1";
        private String deConfigure = "2";
    private PerformerKOM performerKOM;
    private Master master;

    BisTransportService(BDriver driver, Master master, PerformerKOM performerKOM) {
            this.driver = driver;
            this.master = master;
            this.performerKOM = performerKOM;
        }

        public void update() {
            if (driver != null && master != null && performerKOM != null) {
                Word wrd = driver.get();
                String str = wrd.getWord();
                String guid = str.substring(4);
                if (guid.equals(serviceMessage)){
                    String command = str.substring(4,5);
                    if (command.equals(configure)){
                        master.configure(str.substring(5,str.length()));
                    } else if (command.equals(deConfigure)){
                        master.deConfigure();
                    }
                }
            }
        }
    }
