package com.nc.edu.service;

import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;

public interface ISorter {
    Contract[] sort(Contract[] contracts, Comparator<Contract> comparator);
}
