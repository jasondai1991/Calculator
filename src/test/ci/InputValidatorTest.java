package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class InputValidatorTest {

    InputValidator iv = new InputValidator();

    @Test
    public void emptyInputIsNotvalid(){
        String input ="";
        assertFalse(iv.validate(input));
    }

    @Test
    public void diffrentNumOfLeftAndRightParenthesisIsNotValid(){
        String RightMore = "(1+2)*3)";
        String LeftMore = "(((1+2*3)";
        assertFalse(iv.validate(RightMore));
        assertFalse(iv.validate(LeftMore));
    }

    @Test
    public void expressionContainsCharsOtherThanParenthesisNumAndOperatorIsNotValid(){
        String express = "(1+2*m+3)*5";
        String express2 = "(2+3'5*4)";
        assertFalse(iv.validate(express));
        assertFalse(iv.validate(express2));
    }

    @Test
    public void expressionWithSpacesAreValid(){
        String express = " 1+   3*  (5*6)";
        assertTrue(iv.validate(express));
    }


    //Corner cases: two dots; two operators; operator and dot; operator and parenthesis; dot and parenthesis

    @Test
    public void leftParFollowedByNonNumOrLeftParIsNotValid(){
        String express1 = "(1+2*()+5)*10";
        String express2 = "(*1+2)*5";
        String express3 = "(.1+2)*3";
        assertFalse(iv.validate(express1));
        assertFalse(iv.validate(express2));
        assertFalse(iv.validate(express3));
    }

    @Test
    public void rightParFollowedByNumOrLeftParOrDotIsNotValid(){
        String express1 = "(1+2*)(+5)*10";
        String express2 = "(*1+2).5";
        String express3 = "(.1+2)3+5";
        assertFalse(iv.validate(express1));
        assertFalse(iv.validate(express2));
        assertFalse(iv.validate(express3));
    }

    @Test
    public void operatorShouldBeFollowedByNumOrLeftPar(){
        String express1 = "1+2*5";
        String express2 = "1+2*(3+6)";
        String express3 = "1+.2";
        String express4 = "1++2";
        String express5 = "1*)";
        assertTrue(iv.validate(express1));
        assertTrue(iv.validate(express2));
        assertFalse(iv.validate(express3));
        assertFalse(iv.validate(express4));
        assertFalse(iv.validate(express5));
    }

    /*public void OperatorAndDotNotSurroundedByNumsAreNotValid(){
        String twoOperatorsTogetherInput = "(1+2*3/*4)*5";
        assertFalse(iv.validate(twoOperatorsTogetherInput));
    }*/






}