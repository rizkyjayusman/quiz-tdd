package com.cygnus.quiz.util;

import com.cygnus.quiz.entity.Choice;

public class ChoiceUtil {

    public static String createWording(String key, String value) {
        return key + ". " + value;
    }

    public static String createWording(Choice choice) {
        return ChoiceUtil.createWording(choice.getKey(), choice.getValue());
    }

}
