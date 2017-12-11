package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;


public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToToDoList(String element) {
        toDoList.addToList(element);
    }

    public void addToInProgressList(String element) {
        inProgressList.addToList(element);
    }

    public void addToDoneList(String element) {
        doneList.addToList(element);
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
