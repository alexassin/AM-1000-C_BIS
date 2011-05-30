package ru.utorus.am.src.kom;

import ru.utorus.am.src.general.*;


public class DispatcherKOM implements Dispatcher {
    private final Driver driver;
    private int nodeId;

    public DispatcherKOM(final Driver driver, int nodeId) {
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

    class LOKTransportService implements Observer {
        class DriverLOK extends Subscriber {
            public void send(Word wrd) {
                System.out.println(wrd);
            }

            public Word receive() {
                return new Word();
            }
        }

        public void update() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void execute(Word wrd) {
            System.out.println(wrd);
        }

        public void deActivate() {

        }
    }
}
