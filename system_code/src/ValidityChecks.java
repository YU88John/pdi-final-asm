import java.util.Scanner; // For reading user input through the scanner class

/*
- Author: Minn Thit Kyaw
- Date: 25.11.23
*/

public class ValidityChecks {

    /*
     Validates and retrieves a non-empty, non-integer country name from user input.
     */
    public static String validateCountryName(Scanner scanner) {
        String countryName;
        do {
            System.out.print("Country Name: ");
            countryName = scanner.nextLine().trim();

            if (countryName.isEmpty()) {
                System.out.println("Error: Country Name cannot be empty.");
            } else if (isInteger(countryName)) {
                System.out.println("Error: Please enter a valid string for Country Name.");
            }

        } while (countryName.isEmpty() || isInteger(countryName));
        return countryName;
    }

    /*
      Validates and retrieves a non-empty and non-integer national code from user input.
     */

    public static String validateNationalCode(Scanner scanner) {
        String nationalCode;
        do {
            System.out.print("National Code: ");
            nationalCode = scanner.nextLine().trim();

            if (isInteger(nationalCode)) {
                System.out.println("Error: Please enter a valid string for National Code.");
                nationalCode = null;
            } else if (nationalCode.isEmpty()) {
                System.out.println("Error: National Code cannot be empty.");
            }

        } while (nationalCode == null || nationalCode.isEmpty());
        return nationalCode;
    }

    /*
    Checks if a given string can be parsed into an integer.
     */

    private static boolean isInteger(String str) {
        boolean isNumeric = false;

        try {
            Integer.parseInt(str);
            isNumeric = true;
        } catch (NumberFormatException e) {
            // No need to do anything here; isNumeric is already set to false
        }

        return isNumeric;
    }

   /*
   Validates and retrieves a positive integer for detected COVID cases from user input.
   */

    public static int validateDetectedCases(Scanner scanner) {
        int detectedCases;
        do {
            System.out.print("Detected Cases of COVID: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Only positive integers are accepted for Detected Cases.");
                System.out.print("Detected Cases of COVID: ");
                scanner.next();
            }
            detectedCases = scanner.nextInt();
        } while (detectedCases < 0);
        return detectedCases;
    }

    /*
    Validates and retrieves a positive integer for deaths and ensuring it is not greater than detected cases.
    */

    public static int validateDeaths(Scanner scanner, int detectedCases) {
        int deaths;
        do {
            do {
                System.out.print("Deaths from COVID: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Only positive integers are accepted for Deaths.");
                    System.out.print("Deaths from COVID: ");
                    scanner.next();
                }
                deaths = scanner.nextInt();

                // Logically, the number of deaths should not be more than detected cases
                if (deaths > detectedCases) {
                    System.out.println("Error: The number of deaths cannot be greater than detected cases.");
                }
            } while (deaths < 0);

            scanner.nextLine();
        } while (deaths > detectedCases);
        return deaths;
    }

    /*
    Validates and retrieves a continent code from user input, ensuring it matches predefined values.
     */

    public static String validateContinent(Scanner scanner) {
        String continent;
        do {
            System.out.print("Continent (EU, AF, AS, NA, SA, AU, OT): ");
            continent = scanner.next().trim();
        } while (!isValidContinent(continent));
        return continent;
    }

    /*
     * Checks if a given continent code is valid against predefined values.
     * Prints an error message if the continent is invalid.
     * @param continent The input continent code.
     * @return True if the continent is valid, false otherwise.
     */

    private static boolean isValidContinent(String continent) {
        String[] validContinents = {"EU", "AF", "AS", "NA", "SA", "AU", "OT"};
        boolean isValid = false;

        for (String validContinent : validContinents) {
            if (validContinent.equals(continent)) {
                isValid = true;
            }
        }

        if (!isValid) {
            System.out.println("Please enter a valid continent.");
        }

        return isValid;
    }


}


