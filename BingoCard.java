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
        generateBingoCard();
    }

    //This will generate a Bingo card
    /*UNFINISHED */
    private void generateBingoCard() {
        int[][] usedNumbers = new int[5][16]; // Tracks used numbers for each column range
        String[] headers = {"B", "I", "N", "G", "O"};

        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 5; row++) {
                if (row == 2 && col == 2) { 
                    //This is the free space in the middle of the card as per Bingo rules
                    bingoCardArray[row][col] = "XX";
                    bingoCardCheck[row][col] = true;
                    continue;
                }
                int num;
                //This will generate a random number for the card and check if it has been used
                do {
                    // Generate a random number between 1 and 15 for the B column, 16 and 30 for the I column, etc.
                    num = randomCardNum.nextInt(15) + 1 + (col * 15);
                } while (usedNumbers[col][num - (col * 15)] == 1); // This will help with creating uniqueness

                usedNumbers[col][num - (col * 15)] = 1;
                //This will add the number to the card with the letter
                bingoCardArray[row][col] = headers[col] + num;
            }
        }
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
    private boolean markOff(String bingoNum) {
        // This should be a simplier way to mark off the number on the card
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (bingoCardArray[row][col].equals(bingoNum)) {
                    //This will mark the number off on the card
                    bingoCardCheck[row][col] = true;
                    return true;
                }
            }
        }
        return false;
    }

    //This method will check if a line on the Bingo card has been marked off
    private boolean checkLine(int line) {
        for (int i = 0; i < bingoCardCheck[line].length; i++) {
            if (bingoCardCheck[line][i] == false) {
                return false;
            }
        }
        return true;
    }

    //This will check if there is a diagonal bingo on the card
    private boolean checkDiagonal() {
        //This will check the two diagonals on the card
        int count = 0;
        for (int i = 0; i < bingoCardCheck.length; i++) {
            if (bingoCardCheck[i][i] == true) {
                count++;
            }
        }
        if (count == 5) {
            return true;
        }

        count = 0;
        for (int i = 0; i < bingoCardCheck.length; i++) {
            if (bingoCardCheck[i][4 - i] == true) {
                count++;
            }
        }
        if (count == 5) {
            return true;
        }
        return false;
    }

    //This will check for Bingo by columns
    private boolean checkColumn(int column) {
        for (int i = 0; i < bingoCardCheck.length; i++) {
            if (bingoCardCheck[i][column] == false) {
                return false;
            }
        }
        return true;
    }

    //Check for Bingo using the checkLine, checkDiagonal, and checkColumn methods to simplify the check
    private boolean checkBingo() {
        //This will be the code to check for Bingo by rows, columns, and diagonals
        for (int i = 0; i < bingoCardCheck.length; i++) {
            if (checkLine(i) == true) {
                return true;
            }
        }

        for (int i = 0; i < bingoCardCheck.length; i++) {
            if (checkColumn(i) == true) {
                return true;
            }
        }

        if (checkDiagonal() == true) {
            return true;
        }
        return false;
    }



    
}
