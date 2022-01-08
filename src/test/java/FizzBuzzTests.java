import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.PreparedStatement;

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

    static class FizzBuzzStub extends FizzBuzz{
        int counting=1;

        @Override
        public String Say(int i){
            assertEquals(i, counting, "checking sequence " + counting);
            counting ++;
            return String.valueOf(i);
        }
    }

    @Test
    @DisplayName("print 2")
    void PrintTwo(){
        fizzBuzz = new FizzBuzzStub();
        String result = fizzBuzz.Print(2);
        assertEquals("1\n2", result, "Print 2 should equal:\n1\n2" + "\n actual is:\n" + result);
    }

    @Test
    @DisplayName("print 5")
    void PrintFive(){
        fizzBuzz = new FizzBuzzStub();
        String result = fizzBuzz.Print(5);
        assertEquals("1\n2\n3\n4\n5", result, "Print 5 should equal:\n1\n2\n2\n3\n4\n5" + "\n actual is:\n" + result);
    }

    @Test
    @DisplayName("test main")
    void Main(){
        fizzBuzz.main(null);
    }

}
