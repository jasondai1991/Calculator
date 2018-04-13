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





}