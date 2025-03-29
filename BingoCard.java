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
    public BingoCard() {
        this.bingoCardArray = new String[5][5];
        this.bingoCardCheck = new boolean[5][5];
        this.randomCardNum = new Random();
        generateBingoCard();
    }
    //Constructor for the BingoCard class with a name
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

    //This method will help get rows from the Bingo card
    public String[] getRow(int row) {
        return bingoCardArray[row];
    }

    //This will be the method to print the Bingo card.
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
        //parse the string the first spot relative to the letter (column) and the second spot relative to the number (row)
        char letter = bingoNum.charAt(0);
        int num = Integer.parseInt(bingoNum.substring(1));
        int column = -1;
        switch (letter) {
            case 'B':
                column = 0;
                break;
            case 'I':
                column = 1;
                break;
            case 'N':
                column = 2;
                break;
            case 'G':
                column = 3;
                break;
            case 'O':
                column = 4;
                break;
        }
        //This will check the card for the number and mark it off
        for (int i = 0; i < bingoCardArray.length; i++) {
            if (Integer.parseInt(bingoCardArray[i][column].substring(1)) == num) {
                bingoCardCheck[i][column] = true;
                return true;
            }
        }
        return false;
    }

    //This method will check if a line on the Bingo card has been marked off
    public boolean checkLine(int line) {
        for (int i = 0; i < bingoCardCheck[line].length; i++) {
            if (bingoCardCheck[line][i] == false) {
                return false;
            }
        }
        return true;
    }

    //This will check if there is a diagonal bingo on the card
    public boolean checkDiagonal() {
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
    public boolean checkColumn(int column) {
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

    //These methods will be used for testing but can be used for the coding for this class as well

    public BingoCard getCard() {
        return this;
    }

    public String getName() {
        return bingoCardName;
    }
    
    public int getRows() {
        return bingoCardArray.length;
    }

    public int getColumns() {
        return bingoCardArray[0].length;
    }

    public String getBingoCardName() {
        return bingoCardName;
    }
    
    public String[][] getBingoCardArray() {
        return bingoCardArray;
    }
    
    public boolean[][] getBingoCardCheck() {
        return bingoCardCheck;
    }
    
    public boolean hasBingo() {
        return checkBingo();
    }
    
    public boolean markNumber(String bingoNum) {
        return markOff(bingoNum);
    } 

}
