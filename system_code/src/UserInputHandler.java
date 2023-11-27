import java.util.Scanner; // For reading user input through the Scanner class

/*
- Author: Minn Thit Kyaw
- Date: 25.11.23
*/

public class UserInputHandler {

    private Scanner scanner;

    // Arrays to store data for each nation
    private String[] countryNames;
    private String[] nationalCodes;
    private int[] detectedCases;
    private int[] deaths;
    private String[] continents;

    /**
     * Constructs a UserInputHandler instance.
     * @param scanner The Scanner object for reading user input.
     */
    public UserInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public void collectUserInput(int numberOfNations) {
        countryNames = new String[numberOfNations];
        nationalCodes = new String[numberOfNations];
        detectedCases = new int[numberOfNations];
        deaths = new int[numberOfNations];
        continents = new String[numberOfNations];

        for (int i = 0; i < numberOfNations; i++) {
            System.out.println("Enter details for Nation " + (i + 1));

            // Country Name input
            countryNames[i] = ValidityChecks.validateCountryName(scanner);

            // National Code input
            nationalCodes[i] = ValidityChecks.validateNationalCode(scanner);

            // Detected cases input
            detectedCases[i] = ValidityChecks.validateDetectedCases(scanner);

            // Deaths input
            deaths[i] = ValidityChecks.validateDeaths(scanner, detectedCases[i]);

            // Continent input with validation
            continents[i] = ValidityChecks.validateContinent(scanner);

            /*
            Consume the newline character in the buffer after user input,
            excluding the last iteration to address Scanner behavior after using nextInt().
            */
            if (i < numberOfNations - 1) {
                scanner.nextLine();
            }
        }
    }

    // Each aspect of user input (e.g., country name, national code) is handled by separate methods

    public String[] getCountryNames() {
        return countryNames;
    }

    public String[] getNationalCodes() {
        return nationalCodes;
    }

    public int[] getDetectedCases() {
        return detectedCases;
    }

    public int[] getDeaths() {
        return deaths;
    }

    public String[] getContinents() {
        return continents;
    }

}
