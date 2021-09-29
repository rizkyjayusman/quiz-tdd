package cygnus.quiz;

import com.cygnus.quiz.Choice;
import com.cygnus.quiz.Question;
import com.cygnus.quiz.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuizTest {

    public Question getQuestionOne() {
        Question questionOne = new Question();
        questionOne.setQuestion("2 + 2 = ...");
        Choice rightChoice = new Choice("a", "5");
        questionOne.addChoice(rightChoice);
        questionOne.addChoice(new Choice("b", "4"));
        questionOne.setAnswer(rightChoice);

        return questionOne;
    }

    public Question getQuestionTwo() {
        Question questionTwo = new Question();
        questionTwo.setQuestion("1 + 2 = ...");
        questionTwo.addChoice(new Choice("a", "3"));
        Choice rightChoice = new Choice("b", "5");
        questionTwo.addChoice(rightChoice);
        questionTwo.setAnswer(rightChoice);

        return questionTwo;
    }

    public Question getQuestionThree() {
        Question questionThree = new Question();
        questionThree.setQuestion("2 + 1 = ...");
        Choice rightChoice = new Choice("a", "3");
        questionThree.addChoice(rightChoice);
        questionThree.addChoice(new Choice("b", "5"));
        questionThree.setAnswer(rightChoice);

        return questionThree;
    }

    @Test
    public void createQuizWithMaxSizeWasThree_expectCreateQuizSuccess_returnCreateQuizSuccess() {
        Quiz quiz = new Quiz(3);
        Assertions.assertTrue(quiz.isEmpty());

        Question questionOne = getQuestionOne();
        quiz.addQuestion(questionOne);
        Assertions.assertEquals(quiz.peek().getQuestion(), questionOne.getQuestion());

        Question questionTwo = getQuestionTwo();
        quiz.addQuestion(questionTwo);
        Assertions.assertEquals(quiz.peek().getQuestion(), questionTwo.getQuestion());

        Question questionThree = getQuestionThree();
        quiz.addQuestion(questionThree);
        Assertions.assertEquals(quiz.peek().getQuestion(), questionThree.getQuestion());
    }

    @Test
    public void createQuizWithMaxSizeWasTwo_expectCreateQuizFailedCauseAddThreeQuestion_returnCreateQuizFailedCauseAddThreeQuestion() {
        Quiz quiz = new Quiz(2);
        Assertions.assertTrue(quiz.isEmpty());

        Question questionOne = getQuestionOne();
        quiz.addQuestion(questionOne);
        Assertions.assertEquals(quiz.peek().getQuestion(), questionOne.getQuestion());

        Question questionTwo = getQuestionTwo();
        quiz.addQuestion(questionTwo);
        Assertions.assertEquals(quiz.peek().getQuestion(), questionTwo.getQuestion());

        Question questionThree = getQuestionThree();
        quiz.addQuestion(questionThree);

        // cause the quiz size was two, then the question three does not put in to the quiz list.
        // then the quiz list will peek the last question is the question two.
        Assertions.assertEquals(quiz.peek().getQuestion(), questionTwo.getQuestion());
    }

    @Test
    public void userGiveRightAnswerTheQuiz_expectUserSuccessCompletingTheQuiz_returnUserSuccessCompletingTheQuiz() {
        Quiz quiz = new Quiz(2);

        Question questionOne = getQuestionOne();
        quiz.addQuestion(questionOne);
        Assertions.assertEquals("a", quiz.peek().getAnswer().getKey());
        quiz.answerQuestion("a");

        Question questionTwo = getQuestionTwo();
        quiz.addQuestion(questionTwo);
        Assertions.assertEquals("b", quiz.peek().getAnswer().getKey());
        quiz.answerQuestion("b");

        Assertions.assertEquals(2, quiz.getCorrectAnswer());
    }

    @Test
    public void userGiveWrongAnswerTheQuiz_expectUserFailedAnswerTheQuiz_returnUserAnswerTheQuiz() {
        Quiz quiz = new Quiz(2);

        Question questionOne = getQuestionOne();
        quiz.addQuestion(questionOne);
        Assertions.assertNotEquals("b", quiz.peek().getAnswer().getKey());
        quiz.answerQuestion("b");

        Question questionTwo = getQuestionTwo();
        quiz.addQuestion(questionTwo);
        Assertions.assertEquals("b", quiz.peek().getAnswer().getKey());
        quiz.answerQuestion("b");

        Assertions.assertEquals(1, quiz.getCorrectAnswer());
    }

}
