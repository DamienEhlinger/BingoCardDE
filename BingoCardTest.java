
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
public class BingoCardTest {
    private BingoCard bingoCard;

    @Before
    public void setUp() {
        bingoCard = new BingoCard("Test Card 1");
    }

    @Test
    public void testBingoCard() {
        assertTrue(bingoCard.getName().equals("Test Card 1"));
    }

    @Test
    public void testMarkOff() {
        String[][] cardArray = bingoCard.getBingoCardArray();
        String markedNum = cardArray[0][0]; // Pick the first number
        
        // Mark the number and check if it's marked
        assertTrue(bingoCard.markNumber(markedNum));
        assertTrue(bingoCard.getBingoCardCheck()[0][0]);
    }

    @Test
    public void testCheckLine() {
       // Manually mark a full row
       for (int i = 0; i < 5; i++) {
        bingoCard.getBingoCardCheck()[2][i] = true; // Mark the third row
    }

    // Ensure checkLine() correctly detects the bingo
    assertTrue(bingoCard.hasBingo());
    }

    @Test
    public void testCheckDiagonal() {
       // Manually mark a diagonal
       for (int i = 0; i < 5; i++) {
        bingoCard.getBingoCardCheck()[i][i] = true;
    }

    assertTrue(bingoCard.hasBingo());
    }

    @Test
    public void testCheckColumn() {
        // Mark all numbers in a column
        for (int i = 0; i < 5; i++) {
            bingoCard.getBingoCardCheck()[i][1] = true; // Mark the second column
        }

        assertTrue(bingoCard.hasBingo());
    }

    @Test
    public void testCheckBingo() {
         // Ensure there's no bingo initially
         assertFalse(bingoCard.hasBingo());

         // Mark all numbers in a row
         for (int i = 0; i < 5; i++) {
             bingoCard.getBingoCardCheck()[3][i] = true; // Mark fourth row
         }
        
    }

    @Test
    public void testGetRow() {
        String[] row = bingoCard.getRow(1);
        assertEquals(5, row.length); // Bingo card should have 5 columns
    }

    @Test
    public void testPrintBingoCard() {
        String[] row = bingoCard.getRow(1);
        assertEquals(5, row.length); // Bingo card should have 5 columns
    }

}
