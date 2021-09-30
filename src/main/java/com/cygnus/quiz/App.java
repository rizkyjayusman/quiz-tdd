package com.cygnus.quiz;

import com.cygnus.quiz.app.QuizApp;
import com.cygnus.quiz.entity.Choice;
import com.cygnus.quiz.entity.Question;
import com.cygnus.quiz.entity.Quiz;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        while(!end) {
            QuizApp.run();
            System.out.print("Try Again: ");
            String input = scanner.nextLine();
            if(input.equals("N") || input.equals("n")) {
                end = true;
            }
        }
    }

}
