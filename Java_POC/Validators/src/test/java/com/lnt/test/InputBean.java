package com.lnt.test;

import com.lnt.validator.annotations.IntegerOptions;
import com.lnt.validator.annotations.StringOptions;

public class InputBean {

    @StringOptions(empty = false, nullable = false)

    public String val1;

    @StringOptions(nullable = true)
    public String val2;

    @StringOptions(validateEmailId = true)
    public String email;

}
