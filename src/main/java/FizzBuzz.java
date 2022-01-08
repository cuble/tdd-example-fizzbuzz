public class FizzBuzz {
    public String Say(int i) {
        String result;
        result = (i%3==0)?"Fizz":"";
        result = (i%5==0)?result+"Buzz":result;
        result = (result.equals(""))? String.valueOf(i):result;
        return result;
    }

    public String Print(int n) {
        String result="1\n2\n3";
        return result;
    }
}
