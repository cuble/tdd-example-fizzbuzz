import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzTests {
    FizzBuzz fizzBuzz;

    @BeforeEach
    public void before() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest(name = "Say {0} = {1}")
    @CsvSource({
            "1,   false",
            "2,   false",
            "7,   false",
            "3,   true",
            "6,   true",
            "9,   true"
    })
    void MatchThreeTest(int i, Boolean expectResult){
        assertEquals(expectResult, fizzBuzz.isThreeMatched(i), i + " Match three " + expectResult);
    }

    @ParameterizedTest(name = "Say {0} = {1}")
    @CsvSource({
            "1,   false",
            "2,   false",
            "7,   false",
            "5,   true",
            "10,   true",
            "15,   true"
    })
    void MatchFiveTest(int i, Boolean expectResult){
        assertEquals(expectResult, fizzBuzz.isFiveMatched(i), i + " Match three " + expectResult);
    }

    @Test
    @DisplayName("Say When Not Match 3 and 5")
    void SayWhenThreeAndFiveNotMatch(){
        fizzBuzz = spy(fizzBuzz);
        int notMatch = 1;
        when(fizzBuzz.isThreeMatched(notMatch)).thenReturn(false);
        when(fizzBuzz.isFiveMatched(notMatch)).thenReturn(false);
        assertEquals(String.valueOf(notMatch), fizzBuzz.Say(notMatch), "three and five not match return number itself");
    }

    @Test
    @DisplayName("Say When Match 3")
    void SayWhenMatchThree(){
        fizzBuzz = spy(fizzBuzz);
        int matchThree = 3;
        when(fizzBuzz.isThreeMatched(matchThree)).thenReturn(true);
        when(fizzBuzz.isFiveMatched(matchThree)).thenReturn(false);
        assertEquals("Fizz", fizzBuzz.Say(matchThree), "Say Fizz when match three only");
    }

    @Test
    @DisplayName("Say When Match 5")
    void SayWhenMatchFive(){
        fizzBuzz = spy(fizzBuzz);
        int matchFive = 5;
        when(fizzBuzz.isThreeMatched(matchFive)).thenReturn(false);
        when(fizzBuzz.isFiveMatched(matchFive)).thenReturn(true);
        assertEquals("Buzz", fizzBuzz.Say(matchFive), "Say Buzz when match five only");
    }

    @Test
    @DisplayName("Say When Match 3 and 5")
    void SayWhenMatchThreeAndFive(){
        fizzBuzz = spy(fizzBuzz);
        int matchThreeAndFive = 15;
        when(fizzBuzz.isThreeMatched(matchThreeAndFive)).thenReturn(true);
        when(fizzBuzz.isFiveMatched(matchThreeAndFive)).thenReturn(true);
        assertEquals("FizzBuzz", fizzBuzz.Say(matchThreeAndFive), "Say FizzBuzz when match three and Fiver");
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

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;
    private void PrepareForSystemOut(){
        System.setOut(new PrintStream(outContent));
    }

    private void RestoreSystemOut(){
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("test main")
    void Main(){
        final String check = "PrintCalled";
        try(MockedConstruction<FizzBuzz> fizzBuzzMocked = Mockito.mockConstruction(FizzBuzz.class,
                (mock, context)->{
                    when(mock.Print(100)).thenReturn(check);
                })){
            PrepareForSystemOut();
            fizzBuzz.main(null);
            assertEquals(check+"\n", outContent.toString());
            RestoreSystemOut();
        }
    }

}
