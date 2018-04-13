package ci;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputTest {
    @Test
    public void emptyInputIsNotvalid(){
        String input ="";
        assertFalse(Input.validate(input));
    }

    @Test
    public void diffrentLeftAndRightParenthesisIsNotValid(){
        String RightMore = "(1+2)*3)";
        String LeftMore = "(((1+2*3)";
        assertFalse(Input.validate(RightMore));
        assertFalse(Input.validate(LeftMore));
    }

    @Test
    public void twoOperatorsTogetherIsNotValid(){
        String twoOperatorsTogetherInput = "(1+2*3/*4)*5";
        assertFalse(Input.validate(twoOperatorsTogetherInput));
    }

    @Test
    public void aRegularMathExpressionIsValid(){
        String input1 = "1+2*3";
        String input2 = "(1+2)*3*5/3";
        String input3 = "((1*2)/3+5)*10";
        assertTrue(Input.validate(input1));
        assertTrue(Input.validate(input2));
        assertTrue(Input.validate(input3));
    }





}