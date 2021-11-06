package com.nc.edu.database;

import com.nc.edu.essence.contract.Contract;

public class DatabaseContracts {

    public Contract[] contracts;
    private int length;

    public DatabaseContracts() {
        contracts = new Contract[0];
        this.length = contracts.length;
    }


    /**
     * This method returns a contract at the given id
     * @param id of the required contract
     * @return Contract
     */
    public Contract getContractById(long id){
        if (id < 0){
            return null;
        }

        for (int i = 0; i < length; i++) {
            if (contracts[i].getId() == id){
                return contracts[i];
            }
        }
        return null;
    }


    /**
     * This method adds one contract to the database
     * @param contract added element
     */
    public void addContracts(Contract contract){
        changingTheLengthOfAnArray(1);
        contracts[length-1] = contract;
    }


    /**
     * This method adds an array of contractions to the database
     * @param newContracts array of elements to add
     */
    public void addContracts(Contract[] newContracts){
        int lengthAdd = newContracts.length;
        int j = 0;
        changingTheLengthOfAnArray(lengthAdd);
        for (int i = length-lengthAdd; i < length; i++) {
            contracts[i] = newContracts[j];
            j++;
        }
    }


    /**
     * This method removes the contract by id
     * @param id of the contract to be deleted
     */
    public void deleteContractById(long id){

        if (id < 0){
            return;
        }

        boolean marker = false;
        for (int i = 0; i < length; i++) {
            if (contracts[i].getId() == id){
                marker = true;
            }
            if ((marker) & (i != length-1)){
                contracts[i] = contracts[i+1];
            }
        }
        if (marker){
            changingTheLengthOfAnArray(-1);
        }
    }


    /**
     * This method returns an array of contracts that are in the database
     * @return array of Contracts
     */
    public Contract[] getContracts() {
        return contracts;
    }


    /**
     * This method resizes the array
     * @param changeQuantity the number by which the array is modified
     */
    private void changingTheLengthOfAnArray(int changeQuantity){
        Contract[] newContracts = new Contract[length + changeQuantity];
        if (changeQuantity > 0) {
            for (int i = 0; i < length; i++) {
                newContracts[i] = contracts[i];
            }
        } else {
            for (int i = 0; i < newContracts.length; i++) {
                newContracts[i] = contracts[i];
            }
        }
        this.contracts = newContracts;
        this.length = contracts.length;
    }


    /**
     * Compares the passed array with arrays in the data base
     * @param o array to compare
     * @return True - equal, False - not equal
     */
    public boolean equalsArrayContracts(Object[] o){
        if (o.length != contracts.length){
            return false;
        }

        for (int i = 0; i < o.length; i++) {
            if (!(contracts[i].equals(o[i]))){
                return false;
            }
        }
        return true;
    }

    //    public void setContracts(Contract[] contracts) {
//        this.contracts = contracts;
//    }
}