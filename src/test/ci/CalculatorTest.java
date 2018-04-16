package ci;


import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    double delta = 0.00000001;

    //Test Add
    @Test
    public void oneNumAddZeroEqualsItself(){
        String exp="1+0";
        double expectedRes = 1;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void onePlusTwoPointThreeShouldBeThreePointThree(){
        String exp="1+2.3";
        double expectedRes = 3.3;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

}
