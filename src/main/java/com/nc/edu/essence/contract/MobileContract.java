package com.nc.edu.essence.contract;

import com.nc.edu.essence.person.Person;
import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;
import java.util.Objects;

public class MobileContract extends Contract {

//    @CsvBindByPosition(position = 13)
    public int numberOfMinutes;

//    @CsvBindByPosition(position = 14)
    public int numberOfSMS;

//    @CsvBindByPosition(position = 15)
    public int numberOfGBTraffic;

    public MobileContract(long id, LocalDate startData, LocalDate expirationData, long number, Person owner, int numberOfMinutes, int numberOfSMS, int numberOfGBTraffic) {
        super(id, startData, expirationData, number, owner);
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfSMS = numberOfSMS;
        this.numberOfGBTraffic = numberOfGBTraffic;
    }

    public MobileContract() {

    }

    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }

    public void setNumberOfMinutes(int numberOfMinutes) {
        this.numberOfMinutes = numberOfMinutes;
    }

    public int getNumberOfSMS() {
        return numberOfSMS;
    }

    public void setNumberOfSMS(int numberOfSMS) {
        this.numberOfSMS = numberOfSMS;
    }

    public int getNumberOfGBTraffic() {
        return numberOfGBTraffic;
    }

    public void setNumberOfGBTraffic(int numberOfGBTraffic) {
        this.numberOfGBTraffic = numberOfGBTraffic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileContract that = (MobileContract) o;
        return Objects.equals(id, that.id) && Objects.equals(startData, that.startData)
                && Objects.equals(expirationData, that.expirationData) && Objects.equals(number, that.number)
                && Objects.equals(owner, that.owner) && Objects.equals(numberOfMinutes, that.numberOfMinutes)
                && Objects.equals(numberOfSMS, that.numberOfSMS) && Objects.equals(numberOfGBTraffic, that.numberOfGBTraffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfMinutes, numberOfSMS, numberOfGBTraffic);
    }

    @Override
    public String toString() {
        return MobileContract.class.getSimpleName() +
                "{id=" + id +
                ", startData=" + startData +
                ", expirationData=" + expirationData +
                ", number=" + number +
                ", owner=" + owner +
                ", numberOfMinutes=" + numberOfMinutes +
                ", numberOfSMS=" + numberOfSMS +
                ", numberOfGBTraffic=" + numberOfGBTraffic +
                '}';
    }
}
