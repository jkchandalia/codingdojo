public class FizzBuzz {
    public String fizzBuzz(int number) {
        String output = "";
        if (number%3==0){
            output = "Fizz" + output;
        } 
        if (number%5==0){
            output = output + "Buzz";
        }
        else {
            output = String.valueOf(number);
        }
    return output;}
}