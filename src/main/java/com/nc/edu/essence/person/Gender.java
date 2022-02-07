package com.nc.edu.essence.person;

import java.util.Objects;
import java.util.Optional;

public enum Gender {
    MALE(1, "M"),
    FEMALE(2, "F");

    private final int id;
    private final String name;

    Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Optional<Gender> fromName(String name) {
        if (name == null) {
            return Optional.empty();
        }

        for (var value : Gender.values()) {
            if (Objects.equals(value.name, name)) {
                return Optional.of(value);
            }
        }

        return Optional.empty();
    }

}
