package ru.utorus.am.src.bis;

import ru.utorus.am.src.general.Driver;
import ru.utorus.am.src.general.Subscriber;
import ru.utorus.am.src.general.Word;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
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

