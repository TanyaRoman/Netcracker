package com.nc.edu.validation.contract;

import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.contract.DigitalTVContract;
import com.nc.edu.validation.IValidator;
import com.nc.edu.validation.ResultOfValidation;

public class DigitalTVContractValidator implements IValidator {
    @Override
    public ResultOfValidation validation(Contract contract) {
        ResultOfValidation result = new ResultOfValidation();

        ContractValidator contractValidator = new ContractValidator();
        contractValidator.validation(contract);

        DigitalTVContract digitalTVContract = (DigitalTVContract) contract;
        if (digitalTVContract.getChannelPackage() <= 0 || digitalTVContract.getChannelPackage() >500){
            result.addDescription("ChannelPackage is not correct");
        }

        return result;
    }
}
