import java.io.FileNotFoundException; // To handle file not found exceptions.
import java.io.PrintWriter; // For writing data to a file.
import java.util.Scanner; // For user input through the Scanner class.

/*
- Author: Minn Thit Kyaw
- Date: 25.11.23
*/

// This class is called and used by DataEntry.java - main class of the first program

/*
 - This class provides methods for writing data to a CSV file.
 - It is utilized by the main class DataEntry.java for handling CSV file operations.
 */

public class CSVWriter {

    public static String askFileName(Scanner scanner) {
        System.out.print("Enter the name for the CSV file: ");
        scanner.nextLine();
        String fileName = scanner.nextLine().trim();
        return fileName.isEmpty() ? null : fileName + ".csv";
    }

    /*
     * Writes data to a CSV file using the provided file name and data arrays.
     * @param fullFileName The name of the CSV file including the path.
     * @param countryNames An array of country names.
     * @param nationalCodes An array of national codes.
     * @param detectedCases An array of detected cases.
     * @param deaths An array of death counts.
     * @param continents An array of continent names.
     */

    public static void inputToCSV(String fullFileName, String[] countryNames, String[] nationalCodes,
                                  int[] detectedCases, int[] deaths, String[] continents) {
        try (PrintWriter writer = new PrintWriter(fullFileName)) {

            // Write headers as shown in the sample
            writer.println("Country Name, National Code, Detected Cases, Deaths, Continent");

            // Write data for every index of the arrays
            for (int i = 0; i < countryNames.length; i++) {
                writer.println(countryNames[i] + "," +
                        nationalCodes[i] + "," +
                        detectedCases[i] + "," +
                        deaths[i] + "," +
                        continents[i]);
            }

            System.out.println("Data has been written to " + fullFileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}