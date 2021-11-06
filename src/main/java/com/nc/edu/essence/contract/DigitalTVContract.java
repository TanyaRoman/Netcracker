package com.nc.edu.essence.contract;

import com.nc.edu.essence.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class DigitalTVContract extends Contract {

    public int channelPackage;

    public DigitalTVContract(long id, LocalDate startData, LocalDate expirationData, long number, Person owner, int channelPackage) {
        super(id, startData, expirationData, number, owner);
        this.channelPackage = channelPackage;
    }

    public int getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(int channelPackage) {
        this.channelPackage = channelPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DigitalTVContract that = (DigitalTVContract) o;
        return Objects.equals(id, that.id) && Objects.equals(startData, that.startData)
                && Objects.equals(expirationData, that.expirationData) && Objects.equals(number, that.number)
                && Objects.equals(owner, that.owner) && Objects.equals(channelPackage, that.channelPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), channelPackage);
    }

    @Override
    public String toString() {
        return DigitalTVContract.class.getSimpleName() +
                "{id=" + id +
                ", startData=" + startData +
                ", expirationData=" + expirationData +
                ", number=" + number +
                ", owner=" + owner +
                ", channelPackage=" + channelPackage +
                '}';
    }
}
