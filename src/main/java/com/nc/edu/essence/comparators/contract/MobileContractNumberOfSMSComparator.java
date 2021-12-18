package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.MobileContract;

import java.util.Comparator;

public class MobileContractNumberOfSMSComparator implements Comparator<MobileContract> {

    @Override
    public int compare(MobileContract firstContract, MobileContract secondContract) {
        return Integer.compare(firstContract.getNumberOfSMS(), secondContract.getNumberOfSMS());
    }
}
