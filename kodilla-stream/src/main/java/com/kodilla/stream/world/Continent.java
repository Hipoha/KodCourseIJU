package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String name;
    private final List<Country> listOfCountries = new ArrayList<>();

    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        listOfCountries.add(country);
    }

    public String getName() {
        return name;
    }

    public List<Country> getListOfCountries() {
        return new ArrayList<>(listOfCountries);
    }
}
