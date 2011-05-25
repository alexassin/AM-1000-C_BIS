package ru.utorus.am.src.kom;

import ru.utorus.am.src.general.Driver;
import ru.utorus.am.src.general.Subscriber;
import ru.utorus.am.src.general.Word;


public class BDriver extends Subscriber implements Runnable, Driver {
    private String number;
    private Word word;

    BDriver(int nodeNumber) {
        number = String.valueOf(nodeNumber);
    }

    public void run() {
        //main function
    }

    public void send(Word wrd) {
        wrd.setWord(number + wrd.getWord());
        System.out.println(wrd.getWord());
    }

    public Word get() {
        return this.word;
    }
}

