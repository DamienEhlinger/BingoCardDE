
import java.io.File;

public class Main {
    /*This will be the main class for the project to activate and control the other classes.  */
    public static void main(String[] args) {
        System.out.println("Welcome to BingoCardDE!");
        BingoReader bingoReader = new BingoReader();
        bingoReader.readBingoCard(new File("BingoCards.txt"));
        BingoMech bingoMech = new BingoMech();

        
    }
}