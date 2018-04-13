package ci;
import org.junit.Before;
import org.junit.Test;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator interestCalculator;

    @Test
    public void emptyTest(){
        assertEquals("1","1");
    }


}
