package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.contract.InternetContract;
import com.nc.edu.essence.contract.MobileContract;

import java.util.Comparator;

public class InternetContractConnectionSpeedComparator implements Comparator<InternetContract> {

    @Override
    public int compare(InternetContract firstContract, InternetContract secondContract) {
        if (firstContract.getConnectionSpeed() == secondContract.getConnectionSpeed())
            return 0;
        else if (firstContract.getConnectionSpeed() > secondContract.getConnectionSpeed())
            return 1;
        else
            return -1;
    }
}
