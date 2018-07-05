package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> listOfContinents = new ArrayList<>();

    // Default constructor


    public void addContinent(Continent continent) {
        listOfContinents.add(continent);
    }

    public List<Continent> getListOfContinents() {
        return new ArrayList<>(listOfContinents);
    }

    public BigDecimal getPopulation() {
       return listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPopulation)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

}
