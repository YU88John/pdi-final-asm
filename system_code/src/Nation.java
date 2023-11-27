// Class representing information about a nation's COVID-19 statistics
public class Nation {
    // Attributes to store nation-specific data
    private String countryName;
    private String nationalCode;
    private int detectedCases;
    private int deaths;
    private String continent;
    private double percentageOfDeaths;

    // Constructor to initialize the Nation object with data
    public Nation(String countryName, String nationalCode, int detectedCases, int deaths, String continent) {
        this.countryName = countryName;
        this.nationalCode = nationalCode;
        this.detectedCases = detectedCases;
        this.deaths = deaths;
        this.continent = continent;
    }

    // Getter method to retrieve the percentage of deaths
    public double getPercentageOfDeaths() {
        return percentageOfDeaths;
    }

    // Setter method to set the percentage of deaths
    public void setPercentageOfDeaths(double percentageOfDeaths) {
        this.percentageOfDeaths = percentageOfDeaths;
    }

    // Getter method to retrieve the number of detected cases
    public int getDetectedCases() {
        return detectedCases;
    }

    // Getter method to retrieve the number of deaths
    public int getDeaths() {
        return deaths;
    }

    // Getter method to retrieve the continent
    public String getContinent() {
        return continent;
    }

    // Override toString method to provide a formatted string representation of the Nation object
    @Override
    public String toString() {
        return "Nation {" +
                "Country Name='" + countryName + '\'' +
                ", National Code='" + nationalCode + '\'' +
                ", Detected Cases=" + detectedCases +
                ", Deaths=" + deaths +
                ", Continent='" + continent + '\'' +
                ", Percentage of Deaths=" + percentageOfDeaths +
                '}';
    }
}
