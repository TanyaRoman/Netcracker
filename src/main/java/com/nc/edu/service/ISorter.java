package com.nc.edu.service;

import com.nc.edu.essence.contract.Contract;

public interface ISorter {
    void sort(Contract[] contracts, Comparable<Contract> comparable);
}
