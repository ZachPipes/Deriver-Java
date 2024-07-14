import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Beginning statement
        System.out.println("""
                Please enter the function you wish to derive:
                (Format: _x^_ +- _x +- _)
                Note: _ can be any length""");
        System.out.println("Enter function:\n4x^2 - 3x + 2");

        // Get user input
        // Scanner scanner = new Scanner(System.in);
        String userInput = " 4x^3 + x^2 - 3x "; //scanner.nextLine();
        String derivative = "";

        // Loop through entirety of user input
        for(int i = 0; i < userInput.length(); i++) {
            // If not x, continue
            if(userInput.charAt(i) != 'x' && userInput.charAt(i) != '+' && userInput.charAt(i) != '-') { continue; }

            int expo, coeff;
            // Finding the coefficient
            if (userInput.charAt(i - 1) != ' ') {
                int begn = 2;
                while(userInput.charAt(i - begn) != ' ') {
                    begn++;
                }
                coeff = Integer.parseInt(userInput.substring(i - begn + 1, i));
            } else { coeff = 1; }

            // "_ 4 x ^ 2 _ - 3 x _ +  _  6  _"
            // "0 1 2 3 4 5 6 7 8 9 10 11 12 13

            // Finding the exponent
            if (userInput.charAt(i + 1) == '^') {
                int end = i + 3;
                while(userInput.charAt(end) != ' ') {
                    end++;
                }
                expo = Integer.parseInt(userInput.substring(i + 2, i + end - 2));
            } else { expo = 1; }

            // Forming the derivative
            int newcoeff, newexpo;
            newcoeff = coeff * expo;
            newexpo = expo - 1;

            // Dealing with signs
            if (userInput.charAt(i) == '+') {
                if (newcoeff != 0) {
                    derivative += " + ";
                    continue;
                }
            } else if (userInput.charAt(i) == '-') {
                if (newcoeff != 0) {
                    derivative += " - ";
                    continue;
                }
            }

            //Setting the x's
            if (newexpo == 0) {
                derivative += newcoeff;
            } else if (newexpo == 1) {
                derivative += newcoeff + "x";
            } else {
                derivative += newcoeff + "x^" + newexpo;
            }
        } // End of reader
        System.out.println("Derivative | " + derivative);
        // scanner.close();
    }
}
