package com.lnt.test;

import com.lnt.validator.annotations.StringOptions;
import com.lnt.validator.validator.BeanValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestValidator {

    public static void main(String[] args) throws Exception {
        TestValidator test = new TestValidator();
        test.begin();
    }

    public void begin() throws Exception {
        BeanValidator beanValidator = new BeanValidator();
        InputBean inputBean = new InputBean();
        inputBean.val1 = "value1 in the bean";
        inputBean.val2 = "value2 in the bean";

        String msg = beanValidator.validate(inputBean);
        System.out.println("Msg=" + msg);
        if (msg == null || !msg.isEmpty())
            throw new Exception(msg);
    }
}
