import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTests {
    FizzBuzz fizzBuzz;

    @BeforeEach
    public void before() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Say 1")
    void BasePrintOne(){
        assertEquals("1", fizzBuzz.Say(1));
    }

    @Test
    @DisplayName("Say 2")
    void BasePrintTwo(){
        assertEquals("2", fizzBuzz.Say(2));
    }

    @Test
    @DisplayName("Say 3")
    void BasePrintThree(){
        assertEquals("Fizz", fizzBuzz.Say(3));
    }

    @Test
    @DisplayName("Say 6")
    void BasePrintSix(){
        assertEquals("Fizz", fizzBuzz.Say(6));
    }

    @Test
    @DisplayName("Say 5")
    void BasePrintFive(){
        assertEquals("Buzz", fizzBuzz.Say(5));
    }

    @Test
    @DisplayName("Say 10")
    void BasePrintTen(){
        assertEquals("Buzz", fizzBuzz.Say(10));
    }
}
