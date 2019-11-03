import java.util.*;
import java.io.*;
import java.util.HashMap;


public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter = new HashMap<>();

    public void count(String dataFile) throws IOException {
        FileInputStream inStream = new FileInputStream(dataFile);
        Scanner scan = new Scanner(inStream);

        while (scan.hasNext()) {
            wordCounter.compute(scan.next(), (s, c) -> c == null ? 1 : c + 1);
        }

        scan.close();
        inStream.close();
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
