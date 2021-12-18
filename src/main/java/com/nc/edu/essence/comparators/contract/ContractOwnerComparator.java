package com.nc.edu.essence.comparators.contract;

import com.nc.edu.essence.comparators.person.PersonFullNameComparator;
import com.nc.edu.essence.contract.Contract;

import java.util.Comparator;

public class ContractOwnerComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract firstContract, Contract secondContract) {
        PersonFullNameComparator personFullNameComparator = new PersonFullNameComparator();
        return personFullNameComparator.compare(firstContract.getOwner(), secondContract.getOwner());
    }
}
