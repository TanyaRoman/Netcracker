package com.nc.edu.database;

import au.com.bytecode.opencsv.CSVReader;
import com.nc.edu.essence.contract.Contract;

import java.io.FileReader;

public class ParseCSV {

    DatabaseContracts databaseContracts = new DatabaseContracts();

    public void ReaderCSV(String fileName) throws Exception{
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
        Contract[] contracts;

    }

}
