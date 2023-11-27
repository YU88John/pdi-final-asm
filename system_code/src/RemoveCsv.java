import java.io.File;

public class RemoveCsv {

    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = ".";

        // Call the removeCsvFiles method
        removeCsvFiles(new File(directoryPath));
    }

    private static void removeCsvFiles(File directory) {
        // Check if the provided file is a directory
        if (directory.isDirectory()) {
            // Get list of files and directories in the specified directory
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    // Recursively call removeCsvFiles for each file/directory
                    removeCsvFiles(file);
                }
            }
        } else {
            // Check if the file is a .csv file
            if (directory.isFile() && directory.getName().endsWith(".csv")) {
                // Attempt to delete the file
                if (directory.delete()) {
                    System.out.println("Deleted: " + directory.getAbsolutePath());
                } else {
                    System.out.println("Failed to delete: " + directory.getAbsolutePath());
                }
            }
        }
    }
}
