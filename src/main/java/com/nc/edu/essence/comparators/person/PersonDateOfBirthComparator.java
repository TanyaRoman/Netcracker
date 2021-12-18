package com.nc.edu.essence.comparators.person;

import com.nc.edu.essence.person.Person;

import java.util.Comparator;

public class PersonDateOfBirthComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getDateOfBirth().compareTo(secondPerson.getDateOfBirth());
    }
}
