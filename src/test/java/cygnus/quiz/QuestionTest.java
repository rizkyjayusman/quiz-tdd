package cygnus.quiz;


import com.cygnus.quiz.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public void createNormalQuestion_expectSuccessCreated_returnSuccessCreated() {
        String quizQuestion = "2 + 2 = ...";
        String aChoice = "a. 5";
        String bChoice = "b. 4";
        String answer = "b";
        Question question = new Question();
        question.setQuestion(quizQuestion);
        question.setAChoice(aChoice);
        question.setBChoice(bChoice);
        question.setAnswer(answer);

        Assertions.assertEquals(quizQuestion, question.getQuestion());
        Assertions.assertEquals(aChoice, question.getAChoice());
        Assertions.assertEquals(bChoice, question.getBChoice());
        Assertions.assertEquals(answer, question.getAnswer());
    }

    @Test
    public void createQuestionWithoutQuestion_expectFailureCauseQuestionNotFound_returnFailureCauseQuestionNotFound() {
        Question question = new Question();
        Assertions.assertNull(question.getQuestion());
    }


    @Test
    public void createQuestionWithoutAChoice_expectFailureCauseAChoiceNotFound_returnFailureCauseAChoiceNotFound() {
        Question question = new Question();
        Assertions.assertNull(question.getAChoice());
    }

    @Test
    public void createQuestionWithoutBChoice_expectFailureCauseBChoiceNotFound_returnFailureCauseBChoiceNotFound() {
        Question question = new Question();
        Assertions.assertNull(question.getBChoice());
    }

    @Test
    public void createQuestionWithoutAnswer_expectFailureCauseAnswerNotFound_returnFailureCauseAnswerNotFound() {
        Question question = new Question();
        Assertions.assertNull(question.getAnswer());
    }
}