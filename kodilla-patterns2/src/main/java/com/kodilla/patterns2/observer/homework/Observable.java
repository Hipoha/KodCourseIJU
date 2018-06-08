package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void notifyObserver();
    void changeObserver(Observer observer);
}