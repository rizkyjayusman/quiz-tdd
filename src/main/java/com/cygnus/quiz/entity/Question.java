package com.cygnus.quiz.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String question;
    private List<Choice> choiceList;
    private Choice answer;

    private final static int MIN_CHOICE_SIZE = 2;
    private final static int MAX_CHOICE_SIZE = 5;

    public Question() { }

    public void setQuestion(String question) {
        this.question = question;
        this.choiceList = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public List<Choice> getChoiceList() {
        return this.choiceList;
    }

    public void setAnswer(Choice answer) {
        this.answer = answer;
    }

    public Choice getAnswer() {
        return this.answer;
    }

    public void addChoice(Choice choice) {
        if(! isChoiceFull()) {
            choiceList.add(choice);
        }
    }

    public boolean isChoiceFull() {
        return choiceList.size() > MAX_CHOICE_SIZE;
    }

    public boolean isChoiceEmpty() {
        return choiceList.size() < MIN_CHOICE_SIZE;
    }

}
