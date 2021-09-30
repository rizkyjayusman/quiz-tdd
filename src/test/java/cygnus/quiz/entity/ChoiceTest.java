package cygnus.quiz.entity;

import com.cygnus.quiz.entity.Choice;
import com.cygnus.quiz.util.ChoiceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChoiceTest {

    @Test
    public void createNormalChoice_expectCreateChoiceSuccess_returnCreateChoiceSuccess() {
        String key = "a";
        String value = "5";
        Choice choice = new Choice(key, value);

        Assertions.assertEquals(choice.getKey(), key);
        Assertions.assertEquals(choice.getValue(), value);
        Assertions.assertEquals(choice.getChoice(), ChoiceUtil.createWording(key, value));
    }

}
