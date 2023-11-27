import java.io.BufferedReader; // for reading of characters from a character-based input stream, such as reading lines from a file in this case.
import java.io.FileReader; // for reading data from csv file
import java.io.IOException; // to handle errors in file reading operations

/*
- Author: Minn Thit Kyaw
- Date: 26/10/23
 */

// Class for analyzing COVID data
public class DataAnalysis {

    // Method to read COVID data from a CSV file and return an array of Nation objects
    public static Nation[] readCovidData(String filePath) {
        Nation[] nations = null;  // Array to store Nation objects
        int numberOfNations = 0;  // Variable to count the number of nations
        BufferedReader reader = null;  // BufferedReader for reading the file

        try {
            // Open the file for reading
            reader = new BufferedReader(new FileReader(filePath));

            // Read the column header and skip it
            String header = reader.readLine();

            // Count the number of nations in the file
            while (reader.readLine() != null) {
                numberOfNations++;
            }

            // Reset the reader to the beginning of the file
            reader.close();
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine(); // Skip the header

            // Initialize the array to store Nation objects
            nations = new Nation[numberOfNations];

            // Read data line by line
            for (int i = 0; i < numberOfNations; i++) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    // Extract data from the CSV line
                    String countryName = parts[0].trim();
                    String nationalCode = parts[1].trim();
                    int detectedCases = Integer.parseInt(parts[2].trim());
                    int deaths = Integer.parseInt(parts[3].trim());
                    String continent = parts[4].trim();

                    // Create a Nation object and add it to the array
                    nations[i] = new Nation(countryName, nationalCode, detectedCases, deaths, continent);
                }
            }

        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        } finally {
            try {
                // Close the BufferedReader in the finally block
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // Print the stack trace if an IOException occurs while closing the reader
                e.printStackTrace();
            }
        }

        // Return the array of Nation objects
        return nations;
    }

    // Method to calculate the percentage of deaths for each Nation
    public static void calculatePercentage(Nation[] nations) {
        for (Nation nation : nations) {
            if (nation.getDetectedCases() > 0) {
                // Calculate the percentage of deaths and round it to three decimal places
                double percentage = ((double) nation.getDeaths() / nation.getDetectedCases()) * 100;
                double roundedPercentage = Math.round(percentage * 1000.0) / 1000.0;
                nation.setPercentageOfDeaths(roundedPercentage);
            }
        }
    }

    // Method to sort an array of Nation objects by the percentage of deaths
    public static void sortCountriesByPercentage(Nation[] nations) {
        for (int i = 0; i < nations.length - 1; i++) {
            for (int j = i + 1; j < nations.length; j++) {
                if (nations[i].getPercentageOfDeaths() < nations[j].getPercentageOfDeaths()) {
                    // Swap nations if the percentage of deaths is higher in the later position
                    swap(nations, i, j);
                }
            }
        }
    }

    // Method to sort an array of Nation objects by the total number of detected cases
    public static void sortCountriesByTotalCases(Nation[] nations) {
        for (int i = 0; i < nations.length - 1; i++) {
            for (int j = i + 1; j < nations.length; j++) {
                if (nations[i].getDetectedCases() < nations[j].getDetectedCases()) {
                    // Swap nations if the total detected cases are higher in the later position
                    swap(nations, i, j);
                }
            }
        }
    }

    // Method to sort an array of Nation objects by the total number of deaths
    public static void sortCountriesByTotalDeaths(Nation[] nations) {
        for (int i = 0; i < nations.length - 1; i++) {
            for (int j = i + 1; j < nations.length; j++) {
                if (nations[i].getDeaths() < nations[j].getDeaths()) {
                    // Swap nations if the total deaths are higher in the later position
                    swap(nations, i, j);
                }
            }
        }
    }

    // Method to find the Nation with the highest percentage of deaths
    public static Nation findHighestPercentageCountry(Nation[] nations) {
        Nation highestPercentageCountry = nations[0];
        for (int i = 1; i < nations.length; i++) {
            if (nations[i].getPercentageOfDeaths() > highestPercentageCountry.getPercentageOfDeaths()) {
                // Update the highestPercentageCountry if a higher percentage is found
                highestPercentageCountry = nations[i];
            }
        }
        // Return the Nation with the highest percentage of deaths
        return highestPercentageCountry;
    }

    // Private method to swap two elements in an array of Nation objects
    private static void swap(Nation[] nations, int i, int j) {
        Nation temp = nations[i];
        nations[i] = nations[j];
        nations[j] = temp;
    }
}
