package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;

public class ContractStartDataComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract firstContract, Contract secondContract) {
        return firstContract.getStartData().compareTo(secondContract.getStartData());
    }
}
