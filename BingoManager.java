import java.util.ArrayList;
import java.util.List;

public class BingoManager {
    private List<Pattern> patterns;

    public BingoManager() {
        patterns = new ArrayList<>();
    }

    // Method to add a pattern to the manager
    public void addPattern(Pattern pattern) {
        patterns.add(pattern);
    }

    // Method to count the number of Bingos found for any added pattern
    public int countBingos(BingoCard bingoCard) {
        int bingoCount = 0;
        
        for (Pattern pattern : patterns) {
            if (pattern.checkPattern()) {
                bingoCount++;
            }
        }

        return bingoCount;
    }
}
