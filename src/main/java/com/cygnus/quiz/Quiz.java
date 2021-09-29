package com.cygnus.quiz;

public class Quiz {

    private Question[] questionList;
    private int top = -1;
    private int size;
    private int correctAnswer = 0;

    public Quiz(int size) {
        this.size = size;
        questionList = new Question[size];
    }

    public void setQuestionList(Question[] questionList) {
        this.questionList = questionList;
    }

    public Question[] getQuestionList() {
        return this.questionList;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }


    public void addQuestion(Question question) {
        if(! isFull()) {
            top++;
            questionList[top] = question;
        }
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Question peek() {
        if(isEmpty()) {
            return null;
        } else {
            return questionList[top];
        }
    }

    public void pop() {
        if(! isEmpty()) {
            questionList[top] = null;
            top--;
        }
    }

    public void answerQuestion(String answer) {
        if(this.peek().getAnswer().equals(answer)) {
            correctAnswer++;
        }

        pop();
    }

}
