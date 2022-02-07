package com.nc.edu.essence.person;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class FullName {

//    @CsvBindByPosition(position = 5)
    public String surname;

//    @CsvBindByPosition(position = 6)
    public String name;

//    @CsvBindByPosition(position = 7)
    public String patronymic;

    public FullName(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public FullName() {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(surname, fullName.surname) && Objects.equals(name, fullName.name) && Objects.equals(patronymic, fullName.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic);
    }

    @Override
    public String toString() {
        return FullName.class.getSimpleName() +
                "{surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
