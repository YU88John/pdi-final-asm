public class DisplayAnalysis {

    public static void displayResults(Nation[] nations) {
        displaySortedByPercentage(nations);
        displaySortedByTotalCases(nations);
        displaySortedByTotalDeaths(nations);
        displayHighestPercentageCountry(nations);
    }

    private static void displaySortedByPercentage(Nation[] nations) {
        DataAnalysis.sortCountriesByPercentage(nations);
        System.out.println();

        System.out.println("Countries sorted by percentage of deaths (descending order):");
        displayCountries(nations);
        System.out.println(); // Space between next order
    }

    private static void displaySortedByTotalCases(Nation[] nations) {
        DataAnalysis.sortCountriesByTotalCases(nations);

        System.out.println("Countries sorted by total cases (descending order):");
        displayCountries(nations);
        System.out.println(); // Space between next order
    }

    private static void displaySortedByTotalDeaths(Nation[] nations) {
        DataAnalysis.sortCountriesByTotalDeaths(nations);

        System.out.println("\nCountries sorted by total deaths (descending order):");
        displayCountries(nations);
    }

    private static void displayCountries(Nation[] nations) {
        for (Nation nation : nations) {
            System.out.println(nation);
        }
    }

    private static void displayHighestPercentageCountry(Nation[] nations) {
        Nation highestPercentageCountry = DataAnalysis.findHighestPercentageCountry(nations);

        // Display the country with the highest percentage of deaths
        System.out.println("\nCountry with the highest percentage of deaths:");
        System.out.println(highestPercentageCountry);
        System.out.println();
    }
}