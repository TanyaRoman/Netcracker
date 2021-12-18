package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;

public class ContractExpirationDataComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract firstContract, Contract secondContract) {
        return firstContract.getExpirationData().compareTo(secondContract.getExpirationData());
    }
}
