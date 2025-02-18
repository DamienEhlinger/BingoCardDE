import java.util.Random;

public class BingoMech {
    /*This will be where the mechanics of the this game can be built and called in Main when needed. 
     * Here is where the random and manual points will be generated and checked against the bingo card. 
     */

     /*This will be the constructor for the BingoMech class */
    public BingoMech() {

    }

    //This will be the method to generate the random numbers for the bingo game as well as the letter for convinence
    public String generateRandomNumWithLet() {
        Random rand = new Random();
        int randNum = rand.nextInt(98) + 1;
        System.out.println("The random number is: " + randNum);
        //This will be the code to generate the letter for the number ex B-1
        String[] letters = {"B", "I", "N", "G", "O"};
        int randLetter = rand.nextInt(5);
        String letter = letters[randLetter];
        System.out.println("The letter is: " + letter);
        String randNumWithLet = letter + "-" + randNum;
        return randNumWithLet;
    }   

    //This will be the method to check using manual inputs for the bingo game
    public String checkManualInput(String input) {
        String manualNum = input;
        System.out.println("The manual Bingo point is: " + manualNum);
        return manualNum;
    }



    //This will be the method to check the number against the bingo card it will check the number and letter
    //and then check the bingo card to see if the number is on the card. 
    //The way this will work is by first checking the letter and then the number.
    public void checkBingoCard(String bingoDraw, String[][] bingoCardArray) {
        String bingoNum = bingoDraw;
        System.out.println("The Bingo point is: " + bingoNum);
        //check first letter in the string which should be the letter B, I, N, G, or O
        char letter = bingoNum.charAt(0);
        System.out.println("The letter is: " + letter);
        //check the number in the string which should be between 1 and 98 which is after the letter so index 2 to the end
        String num = bingoNum.substring(2);
        System.out.println("The number is: " + num);

        System.out.println("The Bingo point is: " + bingoNum);
        System.out.println("Now checking the bingo card for the number: " + bingoNum);

        //Now we will search the Bingo card for the number
        //So this will need to select which card to check and then check the card for the number

        //This will be the code to check the card for the number
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingoCardArray[i][j].equals(bingoNum)) {
                    System.out.println("The number is on the card!");
                }
                else {
                    System.out.println("The number is not on the card!");
                }
            }
        }

        System.out.println("The Bingo point has been checked!");
    }


}
