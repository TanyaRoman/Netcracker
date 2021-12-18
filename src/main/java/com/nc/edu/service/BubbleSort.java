package com.nc.edu.service;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;


/**
 * Bubble Sort
 */
public class BubbleSort implements ISorter{

    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {

        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < contracts.length; i++) {
                if (comparator.compare(contracts[i], contracts[i-1]) < 0) {
                    Contract tmp = contracts[i];
                    contracts[i] = contracts[i-1];
                    contracts[i-1] = tmp;
                    needIteration = true;
                }
            }
        }
        return contracts;
    }
}
