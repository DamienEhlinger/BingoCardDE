import java.util.List;

public class Pattern {
    //This will chack the types of Bingo patterns you can have. 
    //The patterns will be row, column, diagonal, and custom
    private String patternType;


    public Pattern(String type) {
        this.patternType = type;
    }

    //Check with BingoCard class checkBingo method for the marked positions
    public boolean matches(BingoCard card) {
        boolean[][] marked = card.getMarkedPositions();

        switch (patternType) {
            case "row":
                for (boolean[] row : marked) {
                    if (allMarked(row)) return true;
                    System.out.println("Bingo! You have a row bingo!");
                }
                break;
            case "column":
                for (int col = 0; col < marked[0].length; col++) {
                    if (allMarkedColumn(marked, col)) return true;
                    System.out.println("Bingo! You have a column bingo!");
                }
                break;
            case "diagonal":
                if (checkDiagonals(marked)) return true;
                System.out.println("Bingo! You have a diagonal bingo!");
                break;
            case "custom":
                if (checkCustomPattern(marked)) return true;
                System.out.println("Bingo! You have a custom bingo which is a mix of multiple!");
                break;
        }
        return false;
    }

    
}
