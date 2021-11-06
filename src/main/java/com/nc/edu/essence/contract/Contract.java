package com.nc.edu.essence.contract;

import com.nc.edu.essence.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Contract {

    public long id;
    public LocalDate startData;
    public LocalDate expirationData;
    public long number;
    public Person owner;

    public Contract(long id, LocalDate startData, LocalDate expirationData, long number, Person owner) {
        this.id = id;
        this.startData = startData;
        this.expirationData = expirationData;
        this.number = number;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartData() {
        return startData;
    }

    public void setStartData(LocalDate startData) {
        this.startData = startData;
    }

    public LocalDate getExpirationData() {
        return expirationData;
    }

    public void setExpirationData(LocalDate expirationData) {
        this.expirationData = expirationData;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id) && Objects.equals(startData, contract.startData)
                && Objects.equals(expirationData, contract.expirationData) && Objects.equals(number, contract.number)
                && Objects.equals(owner, contract.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startData, expirationData, number, owner);
    }

    @Override
    public String toString() {
        return Contract.class.getSimpleName() + " {" +
                "id=" + id +
                ", startData=" + startData +
                ", expirationData=" + expirationData +
                ", number=" + number +
                ", owner=" + owner +
                '}';
    }
}
