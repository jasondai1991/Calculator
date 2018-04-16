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

    //Test Minus
    @Test
    public void oneNumMinusZeroEqualsItself(){
        String exp = "5.3-0";
        double expectedRes = 5.3;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void oneNumMinusItselfEqualsZero(){
        String exp = "5.3-5.3";
        double expectedRes = 0;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void oneMinusTwoShouldBeNegOne(){
        String exp = "1-2";
        double expectedRes = -1;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    //Test Multiply
    @Test
    public void oneNumMultiplyZeroShouldBeZero(){
        String exp = "5.3*0";
        double expectedRes = 0;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void twoMultiplyByFiveShouldBeTen(){
        String exp = "2*5";
        double expectedRes = 10;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    //Test Divide
    @Test
     public void zeroAsDenominatorThrowsException(){
        String exp = "5/0.0";
        boolean zeroDenominatorNotAllowed=false;
        try{
           Calculator.calculate(exp);
           System.out.println("haha");
        }catch(CalculatorException e){
           if(e.getMessage().equals("Denominator is Zero")) zeroDenominatorNotAllowed=true;
        }
        assertTrue(zeroDenominatorNotAllowed);
     }

    @Test
    public void oneNumDividedByItselfShouldBeOne(){
        String exp = "5.3/5.3";
        double expectedRes = 1;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void oneDividedByTwoShouldBePointFive(){
        String exp = "1/2";
        double expectedRes = 0.5;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void testWithParens(){
        String exp = "(3+5)*12";
        double expectedRes = 96;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void testWithMultiParens(){
        String exp = "((3+5)*12+4)/10*1.5+5.34";
        double expectedRes = 20.34;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

    @Test
    public void testComplicatedExpression(){
        String exp = "((3*1.5)/(10-3*(3.3-4.4*5)))*10-5.32";
        double expectedRes = -4.63921331316;
        double Res = Double.MAX_VALUE;
        try{
            Res = Calculator.calculate(exp);
        }catch(Exception e){
        }
        assertEquals(expectedRes,Res,delta);
    }

}
