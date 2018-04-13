package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperatorsTest {
    double delta = 0.00000000001;

    //Test Add
    @Test
    public void oneNumAddZeroEqualsItself(){
        double a=3.2;
        double b=0;
        assertEquals(3.2,3.2,delta);
    }

    @Test
    public void testRegularAddOperator(){
        double a = 1;
        double b =2.3;
        assertEquals(3.3,Operators.add(a,b),delta);
    }


}