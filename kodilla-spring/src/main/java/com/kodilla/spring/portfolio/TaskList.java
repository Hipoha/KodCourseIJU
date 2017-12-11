package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private final List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public ArrayList<String> addToList(String element) {
        tasks.add(element);
        return new ArrayList<>(tasks);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

}
