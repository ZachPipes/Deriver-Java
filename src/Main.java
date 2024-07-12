import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Beginning statement
//        System.out.println("""
//                Please enter the function you wish to derive:
//                (Format: _x^_ +- _x +- _)
//                Note: _ can be any length""");
        System.out.println("Enter function:\n4x^2 - 3x + 2");

        // Get user input
        Scanner scanner = new Scanner(System.in);
        String userInput = " 4x^2 - 3x + 2 "; //scanner.nextLine();

        // Loop through entirety of user input
        for(int i = 0; i < userInput.length(); i++) {
            int expo, coeff;
            // If not x, continue
            if(userInput.charAt(i) != 'x') {
                continue;
            }

            // If x, find the coefficient and exponent
            // Finding the coefficient
            if (userInput.charAt(i - 1) != ' ') {
                int begn = 1;
                while(userInput.charAt(i - begn) != ' ') {
                    begn++;
                }
                coeff = Integer.parseInt(userInput.substring(i - begn + 1, i));
            } else { coeff = 1; }
            System.out.println(i + " coeff: " + coeff);

            // Finding the exponent
            if(userInput.charAt(i + 1) == '^') {
                int end = i + 2;
                while(userInput.charAt(end + 1) != ' ') {
                    end++;
                }
                expo = Integer.parseInt(userInput.substring(i + 2, i + end - 1));
            } else { expo = 1; }
            System.out.println(i + " expo: " + expo);
        }
        ///////////Scanner out
    }
}