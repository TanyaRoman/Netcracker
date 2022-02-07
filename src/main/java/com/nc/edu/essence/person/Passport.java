package com.nc.edu.essence.person;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class Passport {

//    @CsvBindByPosition(position = 10)
    public int series;

//    @CsvBindByPosition(position = 11)
    public int number;

    public Passport(int series, int number) {
        this.series = series;
        this.number = number;
    }

    public Passport() {

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
