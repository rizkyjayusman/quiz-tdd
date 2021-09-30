package com.cygnus.quiz.entity;

import com.cygnus.quiz.util.ChoiceUtil;

public class Choice {

    private String key;
    private String value;

    public Choice(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getChoice() {
        return ChoiceUtil.createWording(this);
    }

}
