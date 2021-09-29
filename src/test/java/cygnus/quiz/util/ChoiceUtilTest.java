package cygnus.quiz.util;

import com.cygnus.quiz.Choice;
import com.cygnus.quiz.util.ChoiceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChoiceUtilTest {

    @Test
    public void createWordingChoice_expectCreateWordingSuccess_returnCreateWordingSuccess() {
        Choice choice = new Choice("a", "5");
        Assertions.assertEquals("a. 5", ChoiceUtil.createWording(choice));
    }

    @Test
    public void createWordingChoiceWithKeyAndValue_expectCreateWordingSuccess_returnCreateWordingSuccess() {
        Assertions.assertEquals("a. 5", ChoiceUtil.createWording("a", "5"));
    }

}
