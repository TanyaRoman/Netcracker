package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;

public class ContractNumberComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract firstContract, Contract secondContract) {
        if (firstContract.getNumber() == secondContract.getNumber())
            return 0;
        else if (firstContract.getNumber() > secondContract.getNumber())
                return 1;
            else
                return -1;
    }
}
