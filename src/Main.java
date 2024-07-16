import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sbderivative = new StringBuilder();
        String derivative = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please enter the function you wish to derive.
                Format: (_x^_ +- _x +- _)""");
        String userInput = scanner.nextLine();

        for (int i = 1; i < userInput.length(); i++) {
            int x = i;
            // Coefficient
            while(userInput.charAt(x) != 'x' && x != userInput.length() - 1) {
                x++;
            }
            if (x == userInput.length() - 1) {
                if (sbderivative.charAt(sbderivative.length() - 2) == '+' || sbderivative.charAt(sbderivative.length() - 2) == '-') {
                    sbderivative.delete(sbderivative.length() - 3, sbderivative.length());
                }
                break;
            }
            int coefficient = Integer.parseInt(userInput.substring(i, x));
            i++;

            // Exponent
            int exponent;
            while(userInput.charAt(i) != ' ') {
                i++;
            }
            if (userInput.charAt(x + 1) != '^') {
                exponent = 1;
            } else {
                exponent = Integer.parseInt(userInput.substring(x + 2, i));
            }
            i++;

            int newcoeff = coefficient * exponent;
            int newexpo = exponent - 1;

            // Add to the sb
            if (newexpo == 0) {
                sbderivative.append(newcoeff);
            } else if (newexpo == 1) {
                sbderivative.append(newcoeff + "x");
            } else {
                sbderivative.append(newcoeff + "x^" + newexpo);
            }

            // Signs
            if (userInput.charAt(i) == '+') {
                sbderivative.append(" + ");
                i++;
            } else if (userInput.charAt(i) == '-') {
                sbderivative.append(" - ");
                i++;
            }
        }
        System.out.println(sbderivative.toString());
    }
}