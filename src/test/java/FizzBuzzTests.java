import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTests {

    @Test
    @DisplayName("Say 1")
    void BasePrintOne(){
        FizzBuzz fizzBuzz=new FizzBuzz();
        assertEquals("1", fizzBuzz.Say(1));
    }

    @Test
    @DisplayName("Say 2")
    void BasePrintTwo(){
        FizzBuzz fizzBuzz=new FizzBuzz();
        assertEquals("2", fizzBuzz.Say(2));
    }

    @Test
    @DisplayName("Say 3")
    void BasePrintThree(){
        FizzBuzz fizzBuzz=new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.Say(3));
    }


}
