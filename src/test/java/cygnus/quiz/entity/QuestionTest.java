package cygnus.quiz.entity;


import com.cygnus.quiz.entity.Choice;
import com.cygnus.quiz.entity.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public void createNormalQuestion_expectSuccessCreated_returnSuccessCreated() {
        String quizQuestion = "2 + 2 = ...";

        Question question = new Question();
        question.setQuestion(quizQuestion);
        question.addChoice(new Choice("a", "5"));

        Choice  rightChoice = new Choice("b", "4");
        question.addChoice(rightChoice);
        question.setAnswer(rightChoice);

        Assertions.assertEquals(quizQuestion, question.getQuestion());
        Assertions.assertFalse(question.isChoiceEmpty());
        Assertions.assertFalse(question.isChoiceFull());

        // TODO the problem is how to get the `a` choice or `b` etc choice because we using List<Choice>
        // Assertions.assertEquals(aChoice, question.getAChoice());
        // Assertions.assertEquals(bChoice, question.getBChoice());
        Assertions.assertEquals("b", question.getAnswer().getKey());
    }

    @Test
    public void createQuestionWithoutQuestion_expectFailureCauseQuestionNotFound_returnFailureCauseQuestionNotFound() {
        Question question = new Question();
        Assertions.assertNull(question.getQuestion());
    }


    // TODO the problem is how to get the `a` choice or `b` etc choice because we using List<Choice>
//    @Test
//    public void createQuestionWithoutAChoice_expectFailureCauseAChoiceNotFound_returnFailureCauseAChoiceNotFound() {
//        Question question = new Question();
//        Assertions.assertNull(question.getAChoice());
//    }

//    @Test
//    public void createQuestionWithoutBChoice_expectFailureCauseBChoiceNotFound_returnFailureCauseBChoiceNotFound() {
//        Question question = new Question();
//        Assertions.assertNull(question.getBChoice());
//    }

    @Test
    public void createQuestionWithLessChoiceSize_expectFailureCauseLessThanMinSize_returnFailureCauseLessThanMinSize() {
        String quizQuestion = "2 + 2 = ...";

        Question question = new Question();
        question.setQuestion(quizQuestion);
        Choice  rightChoice = new Choice("a", "4");
        question.addChoice(rightChoice);
        question.setAnswer(rightChoice);

        Assertions.assertTrue(question.isChoiceEmpty());
    }

    @Test
    public void createQuestionWithOverThanChoiceSize_expectFailureCauseOverThanMaxSize_returnFailureCauseOverThanMaxSize() {
        String quizQuestion = "2 + 2 = ...";

        Question question = new Question();
        question.setQuestion(quizQuestion);
        Choice  rightChoice = new Choice("a", "4");
        question.addChoice(new Choice("b", "3"));
        question.addChoice(new Choice("c", "2"));
        question.addChoice(new Choice("d", "1"));
        question.addChoice(new Choice("e", "7"));
        question.addChoice(new Choice("f", "8"));
        question.setAnswer(rightChoice);

        Assertions.assertFalse(question.isChoiceFull());
    }

    @Test
    public void createQuestionWithoutAnswer_expectFailureCauseAnswerNotFound_returnFailureCauseAnswerNotFound() {
        Question question = new Question();
        Assertions.assertNull(question.getAnswer());
    }
}