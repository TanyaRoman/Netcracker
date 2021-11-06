package com.nc.edu;

import com.nc.edu.essence.person.FullName;
import com.nc.edu.essence.person.Gender;
import com.nc.edu.essence.person.Passport;
import com.nc.edu.essence.person.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void yearsOld(){
        Person person1 = new Person(1, new FullName("aa", "ss", "dd"), LocalDate.of(2000, 03, 22), Gender.FEMALE, new Passport(2222, 456879));
        assertEquals(21, person1.yearsOld());
    }
}
