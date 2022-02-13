package com.nc.edu.di;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}
