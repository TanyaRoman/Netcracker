package com.nc.edu;

import com.nc.edu.database.DatabaseContracts;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseContractsTest {

    @Test
    public void getContractById(){
        Person person1 = new Person(1, new FullName("aa", "ss", "dd"), LocalDate.of(1971, 02, 10), Gender.FEMALE, new Passport(2222, 456879));
        DigitalTVContract digitalTVContract1 = new DigitalTVContract(1, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1);
        InternetContract internetContract1 = new InternetContract(2, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 200);
        MobileContract mobileContract1 = new MobileContract(3, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1000, 1000, 7);
        Contract[] contract = new Contract[3];
        contract[0] = digitalTVContract1;
        contract[1] = internetContract1;
        contract[2] = mobileContract1;

        DatabaseContracts databaseContracts = new DatabaseContracts();
        databaseContracts.addContracts(contract);
        assertEquals(digitalTVContract1, databaseContracts.getContractById(1));
        assertEquals(internetContract1, databaseContracts.getContractById(2));
        assertEquals(mobileContract1, databaseContracts.getContractById(3));
    }

    @Test
    public void addContracts(){
        Person person1 = new Person(1, new FullName("aa", "ss", "dd"), LocalDate.of(1971, 02, 10), Gender.FEMALE, new Passport(2222, 456879));
        DigitalTVContract digitalTVContract1 = new DigitalTVContract(1, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1);
        InternetContract internetContract1 = new InternetContract(2, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 200);
        MobileContract mobileContract1 = new MobileContract(3, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1000, 1000, 7);
        Contract[] contract = new Contract[2];
        contract[0] = internetContract1;
        contract[1] = mobileContract1;

        DatabaseContracts databaseContracts = new DatabaseContracts();
        databaseContracts.addContracts(digitalTVContract1);
        assertEquals(digitalTVContract1, databaseContracts.getContractById(1));

        databaseContracts.addContracts(contract);
        Contract[] newContract = new Contract[3];
        newContract[0] = digitalTVContract1;
        newContract[1] = internetContract1;
        newContract[2] = mobileContract1;
        assertTrue(databaseContracts.equalsArrayContracts(newContract));

    }

//    @Test
//    public void addContracts(){
//
//    }

    @Test
    public void deleteContractById(){
        Person person1 = new Person(1, new FullName("aa", "ss", "dd"), LocalDate.of(1971, 02, 10), Gender.FEMALE, new Passport(2222, 456879));
        DigitalTVContract digitalTVContract1 = new DigitalTVContract(1, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1);
        InternetContract internetContract1 = new InternetContract(2, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 200);
        MobileContract mobileContract1 = new MobileContract(3, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1000, 1000, 7);
        Contract[] contract = new Contract[3];
        contract[0] = digitalTVContract1;
        contract[1] = internetContract1;
        contract[2] = mobileContract1;

        DatabaseContracts databaseContracts1 = new DatabaseContracts();
        databaseContracts1.addContracts(contract);
        Contract[] newContract = new Contract[2];
        newContract[0] = internetContract1;
        newContract[1] = mobileContract1;
        databaseContracts1.deleteContractById(1);
        assertTrue(databaseContracts1.equalsArrayContracts(newContract));

        DatabaseContracts databaseContracts2 = new DatabaseContracts();
        databaseContracts2.addContracts(contract);
        newContract[0] = digitalTVContract1;
        newContract[1] = mobileContract1;
        databaseContracts2.deleteContractById(2);
        assertTrue(databaseContracts2.equalsArrayContracts(newContract));

        DatabaseContracts databaseContracts3 = new DatabaseContracts();
        databaseContracts3.addContracts(contract);
        newContract[0] = digitalTVContract1;
        newContract[1] = internetContract1;
        databaseContracts3.deleteContractById(3);
        assertTrue(databaseContracts3.equalsArrayContracts(newContract));
    }

    @Test
    public void getContracts(){

        Person person1 = new Person(1, new FullName("aa", "ss", "dd"), LocalDate.of(1971, 02, 10), Gender.FEMALE, new Passport(2222, 456879));
        DigitalTVContract digitalTVContract1 = new DigitalTVContract(1, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1);
        InternetContract internetContract1 = new InternetContract(2, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 200);
        MobileContract mobileContract1 = new MobileContract(3, LocalDate.of(2021, 03, 22), LocalDate.of(2022, 03, 22), 1, person1, 1000, 1000, 7);
        Contract[] contract = new Contract[3];
        contract[0] = digitalTVContract1;
        contract[1] = internetContract1;
        contract[2] = mobileContract1;

        DatabaseContracts databaseContracts = new DatabaseContracts();
        databaseContracts.addContracts(contract);

        Contract[] newContract = new Contract[3];
        newContract[0] = digitalTVContract1;
        newContract[1] = internetContract1;
        newContract[2] = mobileContract1;

        Contract[] contract2 = databaseContracts.getContracts();

        assertEquals(newContract[0], contract2[0]);
        assertEquals(newContract[1], contract2[1]);
        assertEquals(newContract[2], contract2[2]);
    }
}
