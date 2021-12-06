package com.nc.edu.service;

import com.nc.edu.essence.contract.Contract;

import java.util.List;

public class BubbleSort implements ISorter{

    @Override
    public void sort(Contract[] contracts, Comparable<Contract> comparable) {

        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < contracts.length; i++) {
                if (contracts[i] < contracts[i - 1]) {
                    int tmp = contracts[i];
                    contracts[i] = contracts[i-1];
                    contracts[i-1] = tmp;
                    needIteration = true;
                }
            }
        }
    }
}
