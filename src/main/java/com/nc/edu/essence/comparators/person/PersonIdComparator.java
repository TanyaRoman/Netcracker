package com.nc.edu.essence.comparators.person;

import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.person.Person;

import java.util.Comparator;

public class PersonIdComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if (firstPerson.getId() == secondPerson.getId())
            return 0;
        else if (firstPerson.getId() > secondPerson.getId())
            return 1;
        else
            return -1;
    }
}
