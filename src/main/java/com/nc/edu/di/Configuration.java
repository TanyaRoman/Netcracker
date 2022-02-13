package com.nc.edu.di;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Configuration {
    String[] packages();
}
