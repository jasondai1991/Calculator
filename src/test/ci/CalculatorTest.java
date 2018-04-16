package ci;


import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    double delta = 0.00000001;

    @Test
    public void testSimpleAdd(){
        String exp="1+2+3";
        double expectedRes = 6;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void testSimpleWithDot(){
        String exp="1+2+3.33+3";
        double expectedRes = 9.33;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }
}
