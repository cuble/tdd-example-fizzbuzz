public class FizzBuzz {
    public String Say(int i) {
        String result="";
        if(i%15==0){
            result = "FizzBuzz";
        }else{
            result = (i%3==0)?"Fizz":"";
            result = (i%5==0)?"Buzz":result;
        }
        result = (result.equals(""))? String.valueOf(i):result;
        return result;
    }
}
