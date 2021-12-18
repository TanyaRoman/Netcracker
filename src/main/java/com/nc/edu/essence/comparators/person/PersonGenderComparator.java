package com.nc.edu.essence.comparators.person;

import com.nc.edu.essence.person.Person;

import java.util.Comparator;

public class PersonGenderComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getGender().compareTo(secondPerson.getGender());
    }
}
