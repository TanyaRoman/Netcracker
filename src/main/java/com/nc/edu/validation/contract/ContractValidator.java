package com.nc.edu.validation.contract;

import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.person.FullName;
import com.nc.edu.essence.person.Passport;
import com.nc.edu.essence.person.Person;
import com.nc.edu.validation.IValidator;
import com.nc.edu.validation.ResultOfValidation;

public class ContractValidator implements IValidator {

    @Override
    public ResultOfValidation validation(Contract contract) {
        ResultOfValidation result = new ResultOfValidation();
        contractValidation(result, contract);
        return result;
    }

    private void personValidation(ResultOfValidation result, Contract contract){
        Person person = contract.owner;
        if (person == null){
            result.addDescription("Person is null");
        } else {

            passportValidation(result, contract);
            fullNameValidation(result, contract);

            if (person.getDateOfBirth() == null){
                result.addDescription("DateOfBirth is null");
            } else if (person.yearsOld() < 18 || person.yearsOld() > 100){
                result.addDescription("DateOfBirth is not correct");
            }

            if (person.getGender() == null){
                result.addDescription("Gender is null");
            }

        }
    }

    private void passportValidation(ResultOfValidation result, Contract contract){
        Passport passport = contract.owner.getSeriesAndNumberPassport();
        if (passport == null){
            result.addDescription("passport is null");
        } else {
            if (passport.getSeries() < 1000 || passport.getSeries() > 10000){
                result.addDescription("Series is not correct");
            }

            if (passport.getNumber() < 100000 || passport.getNumber() > 1000000){
                result.addDescription("Number is not correct");
            }
        }
    }

    private void fullNameValidation(ResultOfValidation result, Contract contract){
        FullName fullName = contract.owner.getFullName();
        if (fullName == null){
            result.addDescription("fullName is null");
        } else {

            if (fullName.getName() == null){
                result.addDescription("Name is null");
            } else if (fullName.getName().isBlank()){
                result.addDescription("Name is blank");
            }

            if (fullName.getSurname() == null){
                result.addDescription("Surname is null");
            }else if (fullName.getSurname().isBlank()){
                result.addDescription("Surname is blank");
            }

            if (fullName.getPatronymic() == null){
                result.addDescription("Patronymic is null");
            } else if (fullName.getPatronymic().isBlank()){
                result.addDescription("Patronymic is blank");
            }
        }
    }

    private void contractValidation(ResultOfValidation result, Contract contract){
        if (contract == null){
            result.addDescription("Contract is null");
        } else {
            personValidation(result, contract);

            if (contract.getStartData() == null){
                result.addDescription("StartData is null");
            }

            if (contract.getExpirationData() == null){
                result.addDescription("ExpirationData is null");
            }

            if (contract.getNumber() <= 0){
                result.addDescription("Number is not correct");
            }
        }
    }
}
