package com.nc.edu.database;

import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.contract.DigitalTVContract;
import com.nc.edu.essence.contract.InternetContract;
import com.nc.edu.essence.contract.MobileContract;
import com.nc.edu.essence.person.FullName;
import com.nc.edu.essence.person.Gender;
import com.nc.edu.essence.person.Passport;
import com.nc.edu.essence.person.Person;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV {

    DatabaseContracts databaseContracts = new DatabaseContracts();
    private List<String[]> file;

    public void ReaderCSV(String fileName) {
        try {
            file = readerCSVInString(fileName);
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Passport> passports = parsePassport();
        List<FullName> fullNames = parseFullName();
        List<Person> owners = parseOwner(fullNames, passports);
        List<Contract> contracts = parseContract(owners);

        DatabaseContracts databaseContracts = new DatabaseContracts();
        for (Contract contract : contracts){
            databaseContracts.addContracts(contract);
        }
    }

    private List<String[]> readerCSVInString(String fileName) throws URISyntaxException, IOException, CsvValidationException {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(fileName).toURI()
        ));

        List<String[]> fileBack = new ArrayList<>();

        CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();

        while (csvReader.readNext() != null){
            if (csvReader.readNext().length != 10) continue;
            fileBack.add(csvReader.readNext());
        }

        reader.close();
        csvReader.close();
        return fileBack;
    }

    private List<Passport> parsePassport(){
        List<Passport> passports = new ArrayList<>();

        for (String[] string : file){
            Passport passport = new Passport();
            passport.setSeries(Integer.parseInt(string[8]));
            passport.setNumber(Integer.parseInt(string[9]));
            passports.add(passport);
        }
        return passports;
    }

    private List<FullName> parseFullName(){
        List<FullName> fullNames = new ArrayList<>();

        for (String[] string : file){
            FullName fullName = new FullName();
            fullName.setSurname(string[3]);
            fullName.setName(string[4]);
            fullName.setPatronymic(string[5]);
            fullNames.add(fullName);
        }
        return fullNames;
    }

    private List<Person> parseOwner(List<FullName> fullNames, List<Passport> passports){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        List<Person> owners = new ArrayList<>();
        int k = 0;
        for (String[] string : file){
            Person person = new Person();
            person.setFullName(fullNames.get(k));

            try {
                person.setDateOfBirth(LocalDate.parse(string[6], dateFormatter));
            } catch (DateTimeParseException exception) {
                person.setDateOfBirth(null);
            }

            person.setGender(Gender.fromName(string[7]).orElse(null));
            person.setSeriesAndNumberPassport(passports.get(k));
            owners.add(person);
            k++;
        }
        return owners;
    }

    private List<Contract> parseContract (List<Person> owners){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        List<Contract> contracts = new ArrayList<>();
        int k = 0;
        for (String[] string : file){
            Contract contract = switch (string[10]){
                case "DigitalTV" -> {
                    DigitalTVContract digitalTVContract = new DigitalTVContract();
                    String[] s = string[11].split(",");
                    if (s.length == 1){
                        digitalTVContract.setChannelPackage(Integer.parseInt(s[0]));
                    }
                    yield digitalTVContract;
                }
                case "Internet" -> {
                    InternetContract internetContract = new InternetContract();
                    String[] s = string[11].split(",");
                    if (s.length == 1){
                        internetContract.setConnectionSpeed(Integer.parseInt(s[0]));
                    }
                    yield internetContract;
                }
                case "Mobile" -> {
                    MobileContract mobileContract = new MobileContract();
                    String[] s = string[11].split(",");
                    if (s.length == 3){
                        mobileContract.setNumberOfGBTraffic(Integer.parseInt(s[0]));
                        mobileContract.setNumberOfMinutes(Integer.parseInt(s[0]));
                        mobileContract.setNumberOfSMS(Integer.parseInt(s[0]));
                    }
                    yield mobileContract;
                }
                default -> null;
            };

            try {
                contract.setStartData(LocalDate.parse(string[0], dateFormatter));
            } catch (DateTimeParseException e){
                contract.setStartData(null);
            }

            try {
                contract.setExpirationData(LocalDate.parse(string[1], dateFormatter));
            } catch (DateTimeParseException e){
                contract.setExpirationData(null);
            }

            contract.setNumber(Integer.parseInt(string[2]));
            contract.setOwner(owners.get(k));

            contracts.add(contract);
            k++;
        }
        return contracts;
    }
}
