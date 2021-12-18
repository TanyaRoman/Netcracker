package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.DigitalTVContract;
import com.nc.edu.essence.contract.MobileContract;

import java.util.Comparator;

public class DigitalTVContractChannelPackageComparator implements Comparator<DigitalTVContract> {

    @Override
    public int compare(DigitalTVContract firstContract, DigitalTVContract secondContract) {
        return Integer.compare(firstContract.getChannelPackage(), secondContract.getChannelPackage());
    }
}
