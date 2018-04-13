package ci;

import static org.junit.Assert.*;
import org.junit.Test;

public class InputValidatorTest {

    @Test
    public void emptyInputIsNotvalid(){
        String input ="";
        assertFalse(InputValidator.validate(input));
    }

}