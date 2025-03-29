import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class PatternTest {
    //This will be testing the Pattern class with JUnit testing

    private BingoCard bingoCard;
    private Pattern rowPattern;
    private Pattern columnPattern;
    private Pattern diagonalPattern;
    private Pattern customPattern;

    

    @Before
    public void setUp() {
        bingoCard = new BingoCard();
        rowPattern = new Pattern(bingoCard, "row");
        columnPattern = new Pattern(bingoCard, "column");
        diagonalPattern = new Pattern(bingoCard, "diagonal");
        customPattern = new Pattern(bingoCard, "custom");
    }

    @Test
    public void testPattern() {
        //This will test the Pattern class and that things initialize correctly
        assertNotNull("Pattern should not be null", rowPattern);
        assertNotNull("Pattern should not be null", columnPattern);
        assertNotNull("Pattern should not be null", diagonalPattern);
        assertNotNull("Pattern should not be null", customPattern);
    }

    @Test
    public void testCheckPattern() {
        //This will test the checkPattern method
    }

    @Test
    public void testCheckCustom() {
        //This will test the checkCustom method
    }

    @Test
    public void testCheckTShape() {
        //This will test the checkTShape method
    }

    @Test
    public void testCheckSquare() {
        //This will test the checkSquare method
    }

    @Test
    public void testGetPatternType() {
        //This will test the getPatternType method
    }
}
