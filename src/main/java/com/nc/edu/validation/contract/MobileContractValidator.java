package com.nc.edu.validation.contract;

import com.nc.edu.essence.contract.Contract;
import com.nc.edu.essence.contract.MobileContract;
import com.nc.edu.validation.IValidator;
import com.nc.edu.validation.ResultOfValidation;

public class MobileContractValidator implements IValidator {
    @Override
    public ResultOfValidation validation(Contract contract) {
        ResultOfValidation result = new ResultOfValidation();

        ContractValidator contractValidator = new ContractValidator();
        contractValidator.validation(contract);

        MobileContract mobileContract = (MobileContract) contract;
        if (mobileContract.getNumberOfGBTraffic() <= 0){
            result.addDescription("NumberOfGBTraffic is not correct");
        }

        if (mobileContract.getNumberOfMinutes() <= 0){
            result.addDescription("NumberOfMinutes is not correct");
        }

        if (mobileContract.getNumberOfSMS() <= 0){
            result.addDescription("NumberOfSMS is not correct");
        }

        return result;
    }
}
