package com.pitaza170.accountservice.service.mapper;

import liquibase.pro.packaged.F;
import liquibase.pro.packaged.T;

public interface BaseMapper<F, T> {
    T mapFrom(F object);
    T mapSign(F object);
}
