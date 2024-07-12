import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static boolean isInteger(String s) {
        if(s == null || s.length() == 0) return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse string to int : " + s);
        }
        return false;
    }

    public static void main(String[] args) {
        // Beginning statement
        System.out.println("""
                Please enter the function you wish to derive:
                (Format: _x^_ +- _x +- _)
                Note: _ can be any length""");

        // Get user input
        Scanner scanner = new Scanner(System.in);
        String userInput = "4x^2 - 3x + 2"; //scanner.nextLine();
        System.out.println("\n" + userInput + "\n");

        // Loop through entirety of user input
        for(int i = 0; i < userInput.length(); i++) {
            // If not x, continue
            if(userInput.charAt(i) != 'x') {
                continue;
            }

            // If x, find the coefficient and exponent
            // Finding the coefficient
            int flag = 1;
            while(i - flag > 0 && isInteger(Character.toString(userInput.charAt(i - flag)))) {
                flag++;
            }
            System.out.println("Flag: " + flag + " | i: " + i);
            String coefficient = userInput.substring(flag, i);
            System.out.println("Coeff: " + coefficient);

            // Finding the exponent

        }
        ///////////Scanner out
    }
}