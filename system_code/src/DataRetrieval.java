import java.util.Scanner;
import java.io.File; // for representing file and directory path names

/*
- Author: Minn Thit Kyaw
- Date: 25.11.23
*/

public class DataRetrieval {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath;
        File file;

        // Loop until a valid CSV file path is provided
        do {
            System.out.print("Enter the CSV file path including '.csv' extension: ");
            filePath = scanner.nextLine();

            file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                System.out.println("Invalid file path. Please enter a valid CSV file path.");
            }
        } while (!file.exists() || !file.isFile());

        // Read COVID data from the CSV file
        Nation[] nations = DataAnalysis.readCovidData(filePath);

        boolean continueAnalysis = true;

        while (continueAnalysis) {
            String analysisType;

            // Loop until a valid analysis type is provided
            do {
                System.out.print("Do you want 'overall' analysis or 'continent' analysis? ");
                analysisType = scanner.nextLine().trim(); // trim the whitespaces

                if (!analysisType.equalsIgnoreCase("overall") && !analysisType.equalsIgnoreCase("continent")) {
                    System.out.println("Invalid analysis method. Please enter 'overall' or 'continent' only.");
                }
            } while (!analysisType.equalsIgnoreCase("overall") && !analysisType.equalsIgnoreCase("continent"));

            // Perform analysis based on user's choice
            if (analysisType.equalsIgnoreCase("overall")) {
                // Call the helper methods for analysis output
                DataAnalysis.calculatePercentage(nations);
                DisplayAnalysis.displayResults(nations);
            }
            else if (analysisType.equalsIgnoreCase("continent")) {

                    System.out.print("You can filter by continents as well!");
                    System.out.println("");
                    System.out.print("Enter the continent code to filter (e.g., \"EU\" or \"NA\"): ");
                    String chosenContinent = scanner.nextLine();

                    // Call the GroupAnalysis class for the chosen continent
                    GroupAnalysis.performGroupAnalysis(nations, chosenContinent);
                }

            // Prompt the user for continuing analysis
            System.out.print("Do you want to perform another analysis? \n (Type 'yes' to continue, 'no' to exit): ");
            String continueChoice = scanner.nextLine().trim();

            continueAnalysis = continueChoice.equalsIgnoreCase("yes");

            }

            scanner.close();
        }
    }

