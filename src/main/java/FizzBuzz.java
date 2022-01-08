public class FizzBuzz {
    public String Say(int i) {
        String result="";
        if(i%15==0){
            result = "FizzBuzz";
        }else if(i%5==0){
            result = "Buzz";
        }else if(i%3==0){
            result = "Fizz";
        }
        result = (result.equals(""))? String.valueOf(i):result;
        return result;
    }
}
