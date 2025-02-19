
import java.io.File;

public class Main {
    /*This will be the main class for the project to activate and control the other classes.  */
    public static void main(String[] args) {
        System.out.println("Welcome to BingoCardDE!");
        BingoReader bingoCards = new BingoReader();
        bingoCards.readBingoCard(new File("\"C:\\Users\\ehlingerd4685\\Downloads\\BingoCards.txt\""));
        bingoCards.createBingoCardArray();
        bingoCards.printBingoCard();
        BingoMech bingoMech = new BingoMech();

        //This will be test code to test the random number generator
        String randomNum = bingoMech.generateRandomNumWithLet();
        bingoMech.checkBingoCard(randomNum, bingoCards.getBingoCardArray());



    }
}