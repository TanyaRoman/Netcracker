package com.nc.edu.validation.contract;

import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.contract.InternetContract;
import com.nc.edu.validation.IValidator;
import com.nc.edu.validation.ResultOfValidation;

public class InternetContractValidator implements IValidator {

    @Override
    public ResultOfValidation validation(Contract contract) {
        ResultOfValidation result = new ResultOfValidation();

        ContractValidator contractValidator = new ContractValidator();
        contractValidator.validation(contract);

        InternetContract internetContract = (InternetContract) contract;
        if (internetContract.getConnectionSpeed() <= 0 || internetContract.getConnectionSpeed() >1000){
            result.addDescription("Speed is not correct");
        }

        return result;
    }
}
