import java.util.Scanner;

/**
 * Created by Kelly on 4/12/2016.
 */
public class HarmonicSeriesCalc {

    public static void main(String[] args) {

        boolean getInput = false;

        // Create custom exception handler
        class OutOfBounds extends Exception {

            public OutOfBounds() {
                super();
            }
        }

        // Get user input
        Scanner userInput = new Scanner(System.in);

        // Hold user input
        int terms;
        String input;

        // Display information about the program
        System.out.println("This program computes the sum of the harmonic " +
                "series.");

        do {
            try {
                // Get the number of terms from the user
                System.out.print("\nPlease pick the number of terms, between " +
                        "1 and 100: ");
                input = userInput.nextLine();

                terms = Integer.parseInt(input);

                // Throw exception if user enters number over 100
                if (terms > 100)
                    throw new OutOfBounds();

                // Display the result of the computation
                System.out.println("\nThe sum of the series with " + terms +
                        " term(s) is " + series(terms));

                getInput = true;
            }
            catch (StackOverflowError | NumberFormatException | OutOfBounds ex)
            {
                System.err.println("\nThe input entered is not valid.\n");
            }
        } while (!getInput);
    }

    /**
     * The series method calls the auxiliary method
     * @param terms
     * @return The sum of the series at index 1
     */
    public static double series(double terms) {
        return series(terms, 1); // Call to the auxiliary method
    }

    /**
     * The auxiliary tail-recursive method computes the sum of
     * the harmonic series
     * @param terms
     * @param sum
     * @return A series sum computation or 1 (base case)
     */
    public static double series(double terms, double sum) {

        if (terms == 1)
            return sum;                                 // Base case
        else
            return series((terms - sum)) + 1.0/terms;   // Sum of series
    }
}
