package Utilities;

public class FizzBuzzUtil extends BaseUtil {

    @Override
    public int requestLength() {
        System.out.print("What number do you want to check up to? ");
        return validateLength();
    }

    public void startFizzBuzz(int length) {
        for (int i = 1; i <= length; i++) {
            StringBuilder output = new StringBuilder();
            if (i % 3 == 0) output.append("Fizz");
            if (i % 5 == 0) output.append("Buzz");
            System.out.println(output.isEmpty() ? i :  output);
        }
        System.out.println("\nYup, that was FizzBuzz.");
    }
}
