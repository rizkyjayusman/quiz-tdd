package com.cygnus.quiz;

public class Question {

    private String question;
    private String aChoice;
    private String bChoice;
    private String answer;

    public Question() { }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAChoice(String aChoice) {
        this.aChoice = aChoice;
    }

    public String getAChoice() {
        return this.aChoice;
    }

    public void setBChoice(String bChoice) {
        this.bChoice = bChoice;
    }

    public String getBChoice() {
        return this.bChoice;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }
}
