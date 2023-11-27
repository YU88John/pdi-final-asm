import java.util.Scanner; // We will need Scanner class for reading user inputs
// related classes to this main class - CSVWriter.java, UserInputHandler.java, ValidityChecks.java
// separated similar functionalities into different classes to promote modularity and ease of code maintainability

/*
- Author: Minn Thit Kyaw
- Date: 25.11.23
*/

/*
  This is the main class for the first program.
  This class handles the entry of data for nations, interacts with the user, and orchestrates the data writing process into csv file.
 */

public class DataEntry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of nations
        System.out.print("Enter the number of nations: ");
        int numberOfNations = scanner.nextInt();
        scanner.nextLine();

        // Create an instance of UserInputHandler class
        UserInputHandler userInputHandler = new UserInputHandler(scanner);

        // Call the method to collect user input
        userInputHandler.collectUserInput(numberOfNations);

        // Get the entered data from UserInputHandler
        String[] countryNames = userInputHandler.getCountryNames();
        String[] nationalCodes = userInputHandler.getNationalCodes();
        int[] detectedCases = userInputHandler.getDetectedCases();
        int[] deaths = userInputHandler.getDeaths();
        String[] continents = userInputHandler.getContinents();

        // Ask for the file name to write csv data
        String fileName = CSVWriter.askFileName(scanner);
        String fullFileName = fileName;

        if (fileName != null) {
            // Display entered data for each nation
            System.out.println("Entered Data:");
            for (int i = 0; i < numberOfNations; i++) {
                System.out.println("Nation " + (i + 1) + " - " +
                        "Name: " + countryNames[i] +
                        ", Code: " + nationalCodes[i] +
                        ", Cases: " + detectedCases[i] +
                        ", Deaths: " + deaths[i] +
                        ", Continent: " + continents[i]);
            }

            // Call the method to write data to CSV using CSVWriter class
            CSVWriter.inputToCSV(fullFileName, countryNames, nationalCodes, detectedCases, deaths, continents);

        } else {
            System.out.println("Invalid file name. Please enter a non-empty file name.");
        }

        scanner.close(); // close the scanner - prevent resource leaks
    }
}