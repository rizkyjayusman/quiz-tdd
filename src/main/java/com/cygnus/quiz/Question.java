package com.cygnus.quiz;

public class Question {

    private String question;
    private Choice aChoice;
    private Choice bChoice;
    private Choice answer;

    public Question() { }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAChoice(Choice aChoice) {
        this.aChoice = aChoice;
    }

    public Choice getAChoice() {
        return this.aChoice;
    }

    public void setBChoice(Choice bChoice) {
        this.bChoice = bChoice;
    }

    public Choice getBChoice() {
        return this.bChoice;
    }

    public void setAnswer(Choice answer) {
        this.answer = answer;
    }

    public Choice getAnswer() {
        return this.answer;
    }
}
