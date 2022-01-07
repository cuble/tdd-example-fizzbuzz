import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTests {
    FizzBuzz fizzBuzz;

    @BeforeEach
    public void before() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest(name = "Say {0} = {1}")
    @CsvSource({
            "1,   1",
            "2,   2",
            "7,   7"
    })
    void SayNormal(int i, String expectResult){
        assertEquals(expectResult, fizzBuzz.Say(i), "Say " + i + " should equal " + expectResult);
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

    @Test
    @DisplayName("Say 15")
    void BasePrintFifteen(){
        assertEquals("FizzBuzz", fizzBuzz.Say(15));
    }

    @Test
    @DisplayName("Say 45")
    void BasePrintFortyFive(){
        assertEquals("FizzBuzz", fizzBuzz.Say(45));
    }
}
