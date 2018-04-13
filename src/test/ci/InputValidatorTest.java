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
    public void diffrentNumOfLeftAndRightParenthesisIsNotValid(){
        String RightMore = "(1+2)*3)";
        String LeftMore = "(((1+2*3)";
        assertFalse(InputValidator.validate(RightMore));
        assertFalse(InputValidator.validate(LeftMore));
    }







}