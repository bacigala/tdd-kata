import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {

    public static void main(String[] args) {

    }

    public static Scanner OpenFile(String filename) throws FileNotFoundException {
        try {
            File myObj = new File(filename);
            return new Scanner(myObj);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
    }
}
