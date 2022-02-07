package com.nc.edu.csv;

import com.nc.edu.database.DatabaseContracts;
import com.nc.edu.database.ParseCSV;
import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.contract.DigitalTVContract;
import com.nc.edu.essence.contract.InternetContract;
import com.nc.edu.essence.contract.MobileContract;
import com.nc.edu.essence.person.FullName;
import com.nc.edu.essence.person.Gender;
import com.nc.edu.essence.person.Passport;
import com.nc.edu.essence.person.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCSVTest {

    @Test
    void ParseCSV(){
        Person person1 = new Person(1, new FullName("aa", "ss", "dd"), LocalDate.of(1971, 02, 10), Gender.FEMALE, new Passport(2222, 456879));
        DigitalTVContract digitalTVContract1 = new DigitalTVContract(1, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1);
        InternetContract internetContract1 = new InternetContract(2, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 200);
        MobileContract mobileContract1 = new MobileContract(3, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1000, 1000, 7);
        Contract[] contract = new Contract[3];
        contract[0] = digitalTVContract1;
        contract[1] = internetContract1;
        contract[2] = mobileContract1;

        DatabaseContracts databaseContracts = new DatabaseContracts();
        ParseCSV parseCSV = new ParseCSV();

        parseCSV.ReaderCSV("file.csv");

        assertEquals(digitalTVContract1, databaseContracts.getContractById(1));
        assertEquals(internetContract1, databaseContracts.getContractById(2));
        assertEquals(mobileContract1, databaseContracts.getContractById(3));
    }
}
