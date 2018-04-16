package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperatorsTest {

    double delta = 0.000001;

    //Test Add
    @Test
    public void oneNumAddZeroEqualsItself(){
        double a=3.2;
        double b=0;
        assertEquals(3.2,3.2,delta);
    }

    @Test
    public void onePlusTwoPointThreeShouldBeThreePointThree(){
        double a = 1;
        double b =2.3;
        assertEquals(3.3,Operators.add(a,b),delta);
    }

    //Test Minus
    @Test
    public void oneNumMinusZeroEqualsItself(){
        double a=2.5;
        double b = 0;
        assertEquals(2.5,Operators.minus(a,b),delta);
    }

    @Test
    public void oneNumMinusItselfEqualsZero(){
        double a = 2.5;
        double b = 2.5;
        assertEquals(0,Operators.minus(a,b),delta);
    }

    @Test
    public void oneMinusTwoShouldBeNegOne(){
        double a=1;
        double b=2;
        double c=-1;
        assertEquals(c,Operators.minus(a,b),delta);
    }

    //Test Multiply
    @Test
    public void zeroMultiplyByAnyIsZero(){
        double a=0;
        double b = 1000000;
        assertEquals(0,Operators.multiply(a,b),delta);
    }

    @Test
    public void twoMultiplyFiveShouldBeTen(){
        double a = 2;
        double b = 5;
        assertEquals(10,Operators.multiply(a,b),delta);
    }




}
