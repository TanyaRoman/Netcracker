package com.nc.edu.essence.contract;

import com.nc.edu.essence.person.Person;
import com.opencsv.bean.CsvBindByPosition;

import java.time.LocalDate;
import java.util.Objects;

public class InternetContract extends Contract {

//    @CsvBindByPosition(position = 13)
    public double connectionSpeed;

    public InternetContract(long id, LocalDate startData, LocalDate expirationData, long number, Person owner, double connectionSpeed) {
        super(id, startData, expirationData, number, owner);
        this.connectionSpeed = connectionSpeed;
    }

    public InternetContract() {

    }

    public double getConnectionSpeed() {
        return connectionSpeed;
    }

    public void setConnectionSpeed(double connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternetContract that = (InternetContract) o;
        return Objects.equals(id, that.id) && Objects.equals(startData, that.startData)
                && Objects.equals(expirationData, that.expirationData) && Objects.equals(number, that.number)
                && Objects.equals(owner, that.owner) && Objects.equals(connectionSpeed, that.connectionSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), connectionSpeed);
    }

    @Override
    public String toString() {
        return InternetContract.class.getSimpleName() +
                "{id=" + id +
                ", startData=" + startData +
                ", expirationData=" + expirationData +
                ", number=" + number +
                ", owner=" + owner +
                ", connectionSpeed=" + connectionSpeed +
                '}';
    }
}

