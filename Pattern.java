import java.util.List;


public class Pattern {
    //This will chack the types of Bingo patterns you can have. 
    BingoCard bingoCard;
    //The patterns will be row, column, diagonal, and custom
    private String patternType;

    public Pattern(BingoCard bingoCard, String patternType) {
        this.bingoCard = bingoCard;
        this.patternType = patternType;
    }

    public boolean checkPattern() {
        switch (patternType.toLowerCase()) {
            case "row":
                for (int i = 0; i < bingoCard.getRows(); i++) {
                    if (bingoCard.checkLine(i)) {
                        return true;
                    }
                }
                break;
            case "column":
                for (int i = 0; i < bingoCard.getColumns(); i++) {
                    if (bingoCard.checkColumn(i)) {
                        return true;
                    }
                }
                break;
            case "diagonal":
                return bingoCard.checkDiagonal();
            case "custom":
                return checkCustom();
            default:
                System.out.println("Invalid pattern type.");
                return false;
        }
        return false;
    }


    //This will be the code to check for a custom pattern which is combination of rows, columns, and diagonals
    public boolean checkCustom() {
       return checkTShape() || checkSquare();
    }

    //This will be the code to check for a T shape pattern
    public boolean checkTShape() {
        return bingoCard.checkLine(0) && bingoCard.checkLine(1) && bingoCard.checkLine(2) && bingoCard.checkLine(3) && bingoCard.checkLine(4) ||
                bingoCard.checkColumn(0) && bingoCard.checkColumn(1) && bingoCard.checkColumn(2) && bingoCard.checkColumn(3) && bingoCard.checkColumn(4) ||
                bingoCard.checkDiagonal();
    }

    //This will be the code to check for a square pattern
    public boolean checkSquare() {
        return bingoCard.checkLine(0) && bingoCard.checkLine(1) && bingoCard.checkLine(2) && bingoCard.checkLine(3) && bingoCard.checkLine(4) &&
                bingoCard.checkColumn(0) && bingoCard.checkColumn(1) && bingoCard.checkColumn(2) && bingoCard.checkColumn(3) && bingoCard.checkColumn(4);
    }

    public String getPatternType() {
        return patternType;
    }

    
}
