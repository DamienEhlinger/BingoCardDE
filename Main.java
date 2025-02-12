
import java.io.File;

public class Main {
    /*This will be the main class for the project to activate and control the other classes.  */
    public static void main(String[] args) {
        System.out.println("Welcome to BingoCardDE!");
        BingoReader bingoCards = new BingoReader();
        bingoCards.readBingoCard(new File("BingoCards.txt"));
        bingoCards.createBingoCardArray();
        bingoCards.printBingoCard();
        BingoMech bingoMech = new BingoMech();


    }
}