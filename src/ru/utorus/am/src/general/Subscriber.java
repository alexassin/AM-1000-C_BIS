package ru.utorus.am.src.general;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    private List<Observer> listOfSubscriber = new ArrayList<Observer>();

    public void attach(Observer observer) {
        listOfSubscriber.add(observer);
    }
}
