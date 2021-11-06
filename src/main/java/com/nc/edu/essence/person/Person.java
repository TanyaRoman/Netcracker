package com.nc.edu.essence.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person {

    public long id;
    public FullName fullName;
    public LocalDate dateOfBirth;
    public Gender gender;
    public Passport seriesAndNumberPassport;

    public Person(long id, FullName fullName, LocalDate dateOfBirth, Gender gender, Passport seriesAndNumberPassport) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.seriesAndNumberPassport = seriesAndNumberPassport;
    }

    public int yearsOld(){
        return (int)ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Passport getSeriesAndNumberPassport() {
        return seriesAndNumberPassport;
    }

    public void setSeriesAndNumberPassport(Passport seriesAndNumberPassport) {
        this.seriesAndNumberPassport = seriesAndNumberPassport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(fullName, person.fullName)
                && Objects.equals(dateOfBirth, person.dateOfBirth) && gender == person.gender
                && Objects.equals(seriesAndNumberPassport, person.seriesAndNumberPassport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, dateOfBirth, gender, seriesAndNumberPassport);
    }

    @Override
    public String toString() {
        return Person.class.getSimpleName() +
                "{id=" + id +
                ", fullName=" + fullName +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", seriesAndNumberPassport=" + seriesAndNumberPassport +
                '}';
    }
}
