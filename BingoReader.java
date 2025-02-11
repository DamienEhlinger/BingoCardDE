import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class BingoReader {
    // This will be where the reading of the bingo card will be done
    private String bingoCardFile;
    private String[][] bingoCardArray;
    private File textFile;

    //Constructor for the BingoReader class
    public BingoReader() {
        
    }

    //This will be the method to read the bingo card from the text file
    public void readBingoCard(File textFile) {
        /*This will be the code to read the bingo card the text files are setup in a 5x5 format with
         * the first line being the Card Name ex (Card1) and the next 5 lines being the numbers on the card
         * So main idea is to read the first line as the identifier for the card and then read the next 5 lines 
         * with the double array for the card ex row 1 will be bingoCardArray[0][0] to bingoCardArray[0][4]
         */

        //This will be the code to read the file
        try {
            Scanner fileReader = new Scanner(textFile);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
                //This is the check for the card name ex (Card1) and then the numbers on the card
                if (data.contains("Card")) {
                    System.out.println("This is the card name: " + data);
                } else {
                    System.out.println("This is the numbers on the card: " + data);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred or the file wasn't found.");
            e.printStackTrace();

    }


   
    
    //This will be the method to create the 2D array to store the bingo card
    public void createBingoCardArray() {
        
    }
}
