import java.util.*;
import java.io.*;
import java.util.HashMap;


public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter = new HashMap<>();

    public void count(String dataFile) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(dataFile));
        String compareWords;

        while (scan.hasNext()) {
            compareWords = scan.next();
            if (wordCounter.containsKey(compareWords)) {
                wordCounter.put(compareWords, wordCounter.get(compareWords) + 1);
            }
            else {
                wordCounter.put(compareWords, 1);
            }
        }
        scan.close();
    }

    public void write(String outputFile) throws IOException {
        FileOutputStream outStream = new FileOutputStream(outputFile);
        PrintWriter writer = new PrintWriter(outStream);

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            writer.printf("%s %d\n", entry.getKey(), entry.getValue());
        }

        writer.close();
        outStream.close();
    }
}
