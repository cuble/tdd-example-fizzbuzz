public class FizzBuzz {

    public String Say(int i) {
        String result;
        result = (i%3==0)?"Fizz":"";
        result = (i%5==0)?result+"Buzz":result;
        result = (result.equals(""))? String.valueOf(i):result;
        return result;
    }

    public String Print(int n) {
        String result = "";
        for(int i=1;i<=n;i++){
            result += Say(i);
            result += "\n";
        }
        return result.substring(0, result.length()-1);
    }

    public static void main(String[] argv){
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.Print(100));
    }
}
