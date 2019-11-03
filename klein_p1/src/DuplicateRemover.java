import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
    private HashSet<String> uniqueWords = new HashSet<String>();

    public void remove(String dataFile) throws IOException {
        FileInputStream inStream = new FileInputStream(dataFile);
        Scanner scan = new Scanner(inStream);

        while (scan.hasNext()) {
            uniqueWords.add(scan.next());
        }

        inStream.close();
    }

    public void write(String outputFile) throws IOException {
        FileOutputStream outStream = new FileOutputStream(outputFile);
        PrintWriter writer = new PrintWriter(outStream);

        for (String uniqueWord : uniqueWords) {
            writer.print(uniqueWord + " ");
        }

        writer.close();
        outStream.close();
    }
}
