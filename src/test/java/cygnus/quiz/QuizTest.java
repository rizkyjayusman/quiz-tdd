package cygnus.quiz;

import com.cygnus.quiz.Question;
import com.cygnus.quiz.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuizTest {

    public Question getQuestionOne() {
        Question questionOne = new Question();
        questionOne.setQuestion("2 + 2 = ...");
        questionOne.setAChoice("a. 5");
        questionOne.setBChoice("b. 4");
        questionOne.setAnswer("b");

        return questionOne;
    }

    public Question getQuestionTwo() {
        Question questionTwo = new Question();
        questionTwo.setQuestion("1 + 2 = ...");
        questionTwo.setAChoice("a. 3");
        questionTwo.setAChoice("b. 5");
        questionTwo.setAnswer("a");

        return questionTwo;
    }

    public Question getQuestionThree() {
        Question questionThree = new Question();
        questionThree.setQuestion("2 + 1 = ...");
        questionThree.setAChoice("a. 5");
        questionThree.setAChoice("b. 3");
        questionThree.setAnswer("b");

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
        Question questionOne = getQuestionOne();
        Question questionTwo = getQuestionTwo();
        Quiz quiz = new Quiz(2);
        quiz.addQuestion(questionOne);
        quiz.addQuestion(questionTwo);

        Assertions.assertEquals("a", quiz.peek().getAnswer());
        quiz.pop();

        Assertions.assertEquals("b", quiz.peek().getAnswer());
        quiz.pop();
    }

    @Test
    public void userGiveWrongAnswerTheQuiz_expectUserFailedAnswerTheQuiz_returnUserAnswerTheQuiz() {
        Question questionOne = getQuestionOne();
        Question questionTwo = getQuestionTwo();
        Quiz quiz = new Quiz(2);
        quiz.addQuestion(questionOne);
        quiz.addQuestion(questionTwo);

        Assertions.assertNotEquals("b", quiz.peek().getAnswer());
        quiz.pop();

        Assertions.assertEquals("b", quiz.peek().getAnswer());
        quiz.pop();
    }

}
