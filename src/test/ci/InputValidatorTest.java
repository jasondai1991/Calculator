package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class InputValidatorTest {

    InputValidator iv = new InputValidator();

    @Test
    public void emptyInputIsNotvalid(){
        String input ="";
        assertFalse(iv.isValid(input));
    }

    @Test
    public void diffrentNumOfLeftAndRightParenthesisIsNotValid(){
        String RightMore = "(1+2)*3)";
        String LeftMore = "(((1+2*3)";
        assertFalse(iv.isValid(RightMore));
        assertFalse(iv.isValid(LeftMore));
    }

    @Test
    public void expressionContainsCharsOtherThanParenthesisNumAndOperatorIsNotValid(){
        String express = "(1+2*m+3)*5";
        String express2 = "(2+3'5*4)";
        assertFalse(iv.isValid(express));
        assertFalse(iv.isValid(express2));
    }

    @Test
    public void expressionWithSpacesAreValid(){
        String express = " 1+   3*  (5*6)";
        assertTrue(iv.isValid(express));
    }


    //Corner cases: two dots; two operators; operator and dot; operator and parenthesis; dot and parenthesis

    @Test
    public void leftParFollowedByNonNumOrLeftParIsNotValid(){
        String express1 = "(1+2*()+5)*10";
        String express2 = "(*1+2)*5";
        String express3 = "(.1+2)*3";
        assertFalse(iv.isValid(express1));
        assertFalse(iv.isValid(express2));
        assertFalse(iv.isValid(express3));
    }

    @Test
    public void rightParFollowedByNumOrLeftParOrDotIsNotValid(){
        String express1 = "(1+2*)(+5)*10";
        String express2 = "(*1+2).5";
        String express3 = "(.1+2)3+5";
        assertFalse(iv.isValid(express1));
        assertFalse(iv.isValid(express2));
        assertFalse(iv.isValid(express3));
    }

    @Test
    public void operatorShouldBeFollowedByNumOrLeftPar(){
        String express1 = "1+2*5";
        String express2 = "1+2*(3+6)";
        String express3 = "1+.2";
        String express4 = "1++2";
        String express5 = "1*)";
        assertTrue(iv.isValid(express1));
        assertTrue(iv.isValid(express2));
        assertFalse(iv.isValid(express3));
        assertFalse(iv.isValid(express4));
        assertFalse(iv.isValid(express5));
    }

    @Test
    public void dotOnlyFollowedByNumIsValid(){
        String exp1 = "1.1+5";
        String exp2 = "1.+";
        String exp3 = "1.(3+4)";
        String exp4 = "1..3+4";
        String exp5 = "1.)(*3";
        String exp6 = "3.5.5*6";
        assertTrue(iv.isValid(exp1));
        assertFalse(iv.isValid(exp2));
        assertFalse(iv.isValid(exp3));
        assertFalse(iv.isValid(exp4));
        assertFalse(iv.isValid(exp5));
        assertFalse(iv.isValid(exp6));
    }

    @Test
    public void numShouldNotBeFollowedByLeftPar(){
        String exp = "19(2+3)";
        assertFalse(iv.isValid(exp));
    }

    //Testing expression start rules
    @Test
    public void expressionShouldNotStartWithDot(){
        String exp1 = ".3+3";
        assertFalse(iv.isValid(exp1));
    }

    @Test
    public void expressionShouldNotStartWithRightPar(){
        String exp = ")*3(0";
        assertFalse(iv.isValid(exp));
    }

    @Test
    public void expressionShouldNotStartWithOperator(){
        String exp = "+5*10";
        assertFalse(iv.isValid(exp));
    }

    @Test
    public void expressionCanStartWithNum(){
        String exp = "5*10";
        assertTrue(iv.isValid(exp));
    }

    @Test
    public void expressionCanStartWithLeftPar(){
        String exp = "(5*10)*(3+5)";
        assertTrue(iv.isValid(exp));
    }

    //Testing expression end rules
    @Test
    public void expressionShouldNotEndWithLeftPar(){
        String exp = "30*(5+3/6.2)+5(";
        assertFalse(iv.isValid(exp));
    }

    @Test
    public void expressionShouldNotEndWithOperator(){
        String exp = "30+5*(15+16)-";
        assertFalse(iv.isValid(exp));
    }

    @Test
    public void expressionShouldNotEndWithDot(){
        String exp = "30+5*(15+16).";
        assertFalse(iv.isValid(exp));
    }
}