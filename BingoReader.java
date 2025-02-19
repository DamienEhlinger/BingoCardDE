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
                if (data.contains("Card\\d+")) {
                    System.out.println("This is the card name: " + data);
                    //loop to read the next 5 lines for the numbers on the card
                    for (int i = 0; i < 5; i++) {
                        data = fileReader.nextLine();
                        System.out.println("This is the numbers on the card: " + data);
                    }
                } else {
                    //This is to show there is a blank line
                    //MAKE SURE THIS WORKS
                    System.out.println("This is a blank line");
                    fileReader.nextLine();
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred or the file wasn't found.");
            e.printStackTrace();}

    }


   
    
    //This will be the method to create the 2D array to store the bingo card
    public void createBingoCardArray() {
        bingoCardArray = new String[5][5];
    }

    //This will be the method to print the bingo card
    public void printBingoCard() {
        for (int i = 0; i < bingoCardArray.length; i++) {
            for (int j = 0; j < bingoCardArray[i].length; j++) {
                System.out.print(bingoCardArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String[][] getBingoCardArray() {
        return bingoCardArray;
    }
}
