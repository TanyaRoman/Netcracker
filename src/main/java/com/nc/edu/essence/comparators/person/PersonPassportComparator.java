package com.nc.edu.essence.comparators.person;

import com.nc.edu.essence.person.Person;

import java.util.Comparator;

public class PersonPassportComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int checkSeries = Integer.compare(firstPerson.getSeriesAndNumberPassport().getSeries(), secondPerson.getSeriesAndNumberPassport().getSeries());
        if (checkSeries == 0)
            return Integer.compare(firstPerson.getSeriesAndNumberPassport().getNumber(), secondPerson.getSeriesAndNumberPassport().getNumber());
        return checkSeries;
    }
}
