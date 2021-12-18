package com.nc.edu.service;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;


/**
 * Shuttle Sort
 */
public class ShuttleSort implements ISorter{

    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        for (int i = 1; i < contracts.length; i++) {
            if (comparator.compare(contracts[i], contracts[i-1]) < 0) {
                swap(contracts, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (comparator.compare(contracts[z], contracts[z-1]) < 0) {
                        swap(contracts, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return contracts;
    }

    private void swap(Contract[] array, int ind1, int ind2) {
        Contract tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
