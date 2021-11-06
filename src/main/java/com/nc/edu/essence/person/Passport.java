package com.nc.edu.essence.person;

import java.util.Objects;

public class Passport {

    public int series;
    public int number;

    public Passport(int series, int number) {
        this.series = series;
        this.number = number;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return series == passport.series && number == passport.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(series, number);
    }

    @Override
    public String toString() {
        return Passport.class.getSimpleName() +
                "{series=" + series +
                ", number=" + number +
                '}';
    }
}
