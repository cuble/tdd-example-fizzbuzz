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

    @ParameterizedTest(name = "Say {0} = {1}")
    @CsvSource({
            "3,   Fizz",
            "6,   Fizz",
            "9,   Fizz"
    })
    void SayFizz(int i, String expectResult){
        assertEquals(expectResult, fizzBuzz.Say(i), "Say " + i + " should equal " + expectResult);
    }

    @ParameterizedTest(name = "Say {0} = {1}")
    @CsvSource({
            "5,   Buzz",
            "10,   Buzz",
            "20,   Buzz"
    })
    void SayBuzz(int i, String expectResult){
        assertEquals(expectResult, fizzBuzz.Say(i), "Say " + i + " should equal " + expectResult);
    }

    @ParameterizedTest(name = "Say {0} = {1}")
    @CsvSource({
            "15,   FizzBuzz",
            "30,   FizzBuzz",
            "45,   FizzBuzz"
    })
    void SayFizzBuzz(int i, String expectResult){
        assertEquals(expectResult, fizzBuzz.Say(i), "Say " + i + " should equal " + expectResult);
    }
}
