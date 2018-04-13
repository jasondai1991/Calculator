package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class InputValidatorTest {

    @Test
    public void emptyInputIsNotvalid(){
        String input ="";
        assertFalse(InputValidator.validate(input));
    }

    @Test
    public void diffrentLeftAndRightParenthesisIsNotValid(){
        String RightMore = "(1+2)*3)";
        String LeftMore = "(((1+2*3)";
        assertFalse(InputValidator.validate(RightMore));
        assertFalse(InputValidator.validate(LeftMore));
    }

    @Test
    public void twoOperatorsTogetherIsNotValid(){
        String twoOperatorsTogetherInput = "(1+2*3/*4)*5";
        assertFalse(InputValidator.validate(twoOperatorsTogetherInput));
    }

    @Test
    public void aRegularMathExpressionIsValid(){
        String input1 = "1+2*3";
        String input2 = "(1+2)*3*5/3";
        String input3 = "((1*2)/3+5)*10";
        assertTrue(InputValidator.validate(input1));
        assertTrue(InputValidator.validate(input2));
        assertTrue(InputValidator.validate(input3));
    }

}