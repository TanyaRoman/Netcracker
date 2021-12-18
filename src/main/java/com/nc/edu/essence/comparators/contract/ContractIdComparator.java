package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;

public class ContractIdComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract firstContract, Contract secondContract) {
        if (firstContract.getId() == secondContract.getId())
            return 0;
        else if (firstContract.getId() > secondContract.getId())
                return 1;
            else
                return -1;
    }
}
