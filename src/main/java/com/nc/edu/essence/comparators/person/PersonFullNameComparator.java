package com.nc.edu.essence.comparators.person;

import com.nc.edu.essence.person.Person;

import java.util.Comparator;

public class PersonFullNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int checkSurname = firstPerson.getFullName().getSurname().compareTo(secondPerson.getFullName().getSurname());
        if (checkSurname == 0){
            int checkName = firstPerson.getFullName().getName().compareTo(secondPerson.getFullName().getName());
            if (checkName == 0)
                return firstPerson.getFullName().getPatronymic().compareTo(secondPerson.getFullName().getPatronymic());
            return checkName;
        }
        return checkSurname;
    }
}
