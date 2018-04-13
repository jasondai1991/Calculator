package ci;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputTest {
    @Test
    public void emptyInputIsInvalid(){
        Calculator cl = new Calculator();
        String input ="";
        assertFalse(Input.validate(input));
    }

    /*@Test
    public void LeftAndRightParenthesesShouldBeSameNumber(){

    }*/



}