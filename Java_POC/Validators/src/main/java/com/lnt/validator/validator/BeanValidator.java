package com.lnt.validator.validator;

import com.lnt.validator.annotations.StringOptions;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanValidator {

    String fieldName;
    String fieldValue;
    //String Options
    boolean nullable;
    boolean empty;
    //Integer Options
    int min;
    int max;

    public String validate(Object obj) throws Exception {
        String msg = "";

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            StringOptions annotations = field.getDeclaredAnnotation(StringOptions.class);

            fieldName = field.getName();
            try {
                fieldValue = field.get(obj).toString();
            } catch (NullPointerException npe) {
                fieldValue = null;
            }

            if (annotations.nullable())
                msg += checkNullable();
            if (annotations.empty())
                msg += checkEmpty();
            if (annotations.validateEmailId())
                msg += validateEmailId();
            System.out.println(annotations);

        }
        return msg;
    }

    private String validateEmailId() {
        if (fieldValue == null || fieldValue.isEmpty())
            return fieldName + " Can't be null/empty";
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(fieldValue);
        if (matcher.matches())
            return "";
        return fieldName + " email Id is not valid.";
    }

    private String checkEmpty() {
        if (fieldValue == null || fieldValue.isEmpty())
            return fieldName + " Can't be empty";
        return "";
    }

    private String checkNullable() {
        if (fieldValue == null)
            return "The " + fieldName + " Can't be null.";
        return "";
    }

}
