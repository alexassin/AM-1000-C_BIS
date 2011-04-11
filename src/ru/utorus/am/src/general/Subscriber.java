package ru.utorus.am.src.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 13:55
 * To change this template use File | Settings | File Templates.
 */
public class Subscriber {
    List<Observer> listOfSubscriber = new ArrayList<Observer>();

    public void attach(Observer observer) {
        listOfSubscriber.add(observer);
    }
}
