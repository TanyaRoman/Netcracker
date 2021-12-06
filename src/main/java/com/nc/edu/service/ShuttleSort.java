package com.nc.edu.service;

import com.nc.edu.essence.contract.Contract;

public class ShuttleSort implements ISorter{

    @Override
    public void sort(Contract[] contracts, Comparable<Contract> comparable) {
        for (int i = 1; i < contracts.length; i++) {
            if (contracts[i] < contracts[i - 1]) {
                swap(contracts, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (contracts[z] < contracts[z - 1]) {
                        swap(contracts, z, z - 1);
                    } else {
                        break;
                    }
                }
                comparable.compareTo(contracts[i]);
            }
        }


    }

    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
