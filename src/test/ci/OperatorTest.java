package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperatorTest {

    double delta = 0.000001;

    //Test Add
    @Test
    public void oneNumAddZeroEqualsItself(){
        double a=3.2;
        double b=0;
        assertEquals(3.2,Operator.operation('+',a,b),delta);
    }

    @Test
    public void onePlusTwoPointThreeShouldBeThreePointThree(){
        double a = 1;
        double b =2.3;
        assertEquals(3.3, Operator.operation('+',a,b),delta);
    }

}
