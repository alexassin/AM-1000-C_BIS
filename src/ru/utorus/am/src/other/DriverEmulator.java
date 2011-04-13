package ru.utorus.am.src.other;

import ru.utorus.am.src.general.Driver;
import ru.utorus.am.src.general.Observer;
import ru.utorus.am.src.general.Performer;
import ru.utorus.am.src.general.TargetMessage;


import java.lang.annotation.Target;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DriverEmulator implements Runnable, Driver {
    private Performer performer;

    public void send(ru.utorus.am.src.general.Word wrd) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public ru.utorus.am.src.general.Word get() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    Observer transportationService;
    final int port = 2026;
    DatagramSocket dSocket;
    DatagramPacket packet;
    DatagramPacket sndPacket;
    byte[] buffer;

    public DriverEmulator(Observer transportService, Performer performer) {
        this.transportationService = transportService;
        this.performer = performer;
        try {
            dSocket = new DatagramSocket(port);
            buffer = new byte[2048];
            packet = new DatagramPacket(buffer, buffer.length);
        } catch (Exception E) {
            System.out.print(E);
        }
    }

    public void send(byte[] _msg) {
        try {
            String host = "255.255.255.255";
            InetAddress address = InetAddress.getByName(host);
            sndPacket = new DatagramPacket(_msg, _msg.length, address, port);
            DatagramSocket dsocket = new DatagramSocket();
            dsocket.send(sndPacket);
            dsocket.close();
        } catch (Exception E) {
            System.err.println(E);
        }
    }


    public void run() {
        String[] message = new String[100];
        try {
            while (true) {
                dSocket.receive(packet);
                String msg = new String(buffer, 0, packet.getLength());
                packet.setLength(buffer.length);
                //debug
                message[0] = "";
                if (!msg.isEmpty()) {
                    message = msg.split(":");
                }

                Word wrd = new Word();
                for (String intstr : message) {
                    try {
                        wrd.write(Integer.parseInt(intstr));
                    } catch (Exception E) {

                    }
                }
                int guid = wrd.read();
                if (guid == 2026) { //message from master
                    wrd.next();
                    int descriptor = wrd.read();
                    if (descriptor == 0) {
                        performer.execute(new TargetMessage(wrd.toString()));
                    }
                    if (descriptor == 1) {
                        wrd.next();
                        transportationService.update();

                    }
                }

            }
        } catch (Exception E) {
            System.err.println(E);
        }
    }
}

