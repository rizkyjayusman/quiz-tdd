package com.cygnus.quiz.app;

import com.cygnus.quiz.entity.Choice;
import com.cygnus.quiz.entity.Question;
import com.cygnus.quiz.entity.Quiz;

import java.util.Scanner;

public class QuizApp {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        Quiz quiz = new Quiz(3);
        quiz.addQuestion(createQuestion("1 + 1 = ...", new Choice[] {new Choice("a", "5"), new Choice("b", "2")}, new Choice("b","2")));
        quiz.addQuestion(createQuestion("3 + 2 = ...", new Choice[] {new Choice("a", "5"), new Choice("b", "4")}, new Choice("a","5")));
        quiz.addQuestion(createQuestion("1 + 2 = ...", new Choice[] {new Choice("a", "5"), new Choice("b", "3")}, new Choice("b","3")));

        for(int i = 0; i < 3; i++) {
            Question question = quiz.peek();
            System.out.println(question.getQuestion());
            for(Choice choice: question.getChoiceList()) {
                System.out.println(choice.getChoice());
            }
            System.out.print("answer: ");
            String input = scanner.nextLine();
            quiz.answerQuestion(input);
        }

        System.out.println("Score: " + quiz.getCorrectAnswer() + "/" + quiz.getSize());
    }

    private static Question createQuestion(String questionStr, Choice[] choices, Choice answer) {
        Question question = new Question();
        question.setQuestion(questionStr);
        for(Choice choice: choices) {
            question.addChoice(choice);
        }
        question.setAnswer(answer);

        return question;
    }

}
