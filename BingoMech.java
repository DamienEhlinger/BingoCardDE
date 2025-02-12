import java.util.Random;

public class BingoMech {
    /*This will be where the mechanics of the this game can be built and called in Main when needed. 
     * Here is where the random and manual points will be generated and checked against the bingo card. 
     */

     /*This will be the constructor for the BingoMech class */
    public BingoMech() {
       
    }

    //This will be the method to generate the random numbers for the bingo game
    public int generateRandomNumber() {
        Random rand = new Random();
        int randNum = rand.nextInt(98) + 1;
        System.out.println("The random number is: " + randNum);
        return randNum;
    }   

    //This will be the method to check using manual inputs for the bingo game
    public int checkManualInput(int input) {
        int manualNum = input;
        System.out.println("The manual number is: " + manualNum);
        return manualNum;
    }

    //This will be the method to check the number against the bingo card

}
