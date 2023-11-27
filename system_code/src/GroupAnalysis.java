// Class for performing group analysis based on chosen continents
public class GroupAnalysis {

    // Method to perform analysis on nations of a chosen continent
    public static void performGroupAnalysis(Nation[] nations, String chosenContinent) {
        // Filter nations based on the chosen continent
        Nation[] filteredNations = filterByContinent(nations, chosenContinent);

        if (filteredNations.length > 0) {
            // Call helper methods for analysis output for the chosen continent
            DataAnalysis.calculatePercentage(filteredNations);
            DisplayAnalysis.displayResults(filteredNations);
        } else {
            System.out.println("No data available for the chosen continent: " + chosenContinent);
        }
    }

    // Private method to filter nations based on the chosen continent
    private static Nation[] filterByContinent(Nation[] nations, String chosenContinent) {
        // Count the number of nations in the chosen continent
        int count = 0;
        for (Nation nation : nations) {
            if (nation.getContinent().equalsIgnoreCase(chosenContinent)) {
                count++;
            }
        }

        // Initialize the array for the chosen continent
        Nation[] filteredNations = new Nation[count];
        int index = 0;

        // Add nations from the chosen continent to the array
        for (Nation nation : nations) {
            if (nation.getContinent().equalsIgnoreCase(chosenContinent)) {
                filteredNations[index++] = nation;
            }
        }

        // Return the array of nations for the chosen continent
        return filteredNations;
    }
}
