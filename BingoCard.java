import java.util.Random;

//This will be for the class assignment since I didn't complete the original assignment. 
//This will be the BingoCard class that will be used to generate the Bingo card for the game.
//and have a boolean check system to check the card for the numbers called and mark them off.
public class BingoCard {
    private String[][] bingoCardArray;
    private boolean[][] bingoCardCheck;
    private String bingoCardName;
    private Random randomCardNum;

    //Constructor for the BingoCard class
    public BingoCard(String name) {
        bingoCardName = name;
        this.bingoCardArray = new String[5][5];
        this.bingoCardCheck = new boolean[5][5];
        this.randomCardNum = new Random();

    }

    //This will generate a Bingo card
    /*UNFINISHED */
    private void generateBingoCard() {
        //This will be the code to generate the Bingo card
        String[] letters = {"B", "I", "N", "G", "O"};
        
    

    }

    //This will be the method to print the Bingo card. First it will print the name of the card and then the card itself
    public void printBingoCard() {
        System.out.println("The Bingo card name is: " + bingoCardName);
        for (int i = 0; i < bingoCardArray.length; i++) {
            for (int j = 0; j < bingoCardArray[i].length; j++) {
                System.out.print(bingoCardArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //This will mark off the number on the Bingo card 
    private void markOff(String bingoNum) {
        //This will be the code to mark off the number on the Bingo card
        //check first letter in the string which should be the letter B, I, N, G, or O
        char letter = bingoNum.charAt(0);
        System.out.println("The letter is: " + letter);

        //check the number in the string which should be between 1 and 98 which is after the letter so index 2 to the end
        String num = bingoNum.substring(1);
        //parse the string to an int
        int numConvert = Integer.parseInt(num);
        System.out.println("The number is: " + numConvert);

        //Now we will search the Bingo card for the number
        //So this will need to select which card to check and then check the card for the number
        for (int i = 0; i < bingoCardArray.length; i++) {
            for (int j = 0; j < bingoCardArray[i].length; j++) {
                if (bingoCardArray[i][j].equals(bingoNum)) {
                    bingoCardCheck[i][j] = true;
                }
            }
        }
    }

    //Check for Bingo
    /*UNFINISHED */
    private boolean checkBingo() {
        //This will be the code to check for Bingo by rows, columns, and diagonals
        //Check for Bingo by rows
        for (int i = 0; i < bingoCardCheck.length; i++) {
            int count = 0;
            for (int j = 0; j < bingoCardCheck[i].length; j++) {
                if (bingoCardCheck[i][j] == true) {
                    count++;
                }
            }
            if (count == 5) {
                return true;
            }
        }

        //Check for Bingo by columns
        for (int i = 0; i < bingoCardCheck.length; i++) {
            int count = 0;
            for (int j = 0; j < bingoCardCheck[i].length; j++) {
                if (bingoCardCheck[j][i] == true) {
                    count++;
                }
            }
            if (count == 5) {
                return true;
            }
        }

        //Check for Bingo by diagonals
        int count = 0;
        for (int i = 0; i < bingoCardCheck.length; i++) {
            if (bingoCardCheck[i][i] == true) {
                count++;
            }
        }

        if (count == 5) {
            return true;
        }

    }



    
}
