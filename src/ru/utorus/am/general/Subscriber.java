package ru.utorus.am.general;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 28.03.11
 * Time: 13:55
 * To change this template use File | Settings | File Templates.
 */
public class Subscriber {
    List<Observer> listOfSubscriber = new LinkedList<Observer>();

    public void attach(Observer observer) {
        listOfSubscriber.add(observer);
    }
}
