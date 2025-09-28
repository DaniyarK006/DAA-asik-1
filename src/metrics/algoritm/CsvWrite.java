//import java.util.Scanner;
package metrics.algoritm;

    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.List;

    public class CsvWrite {

    public static void write(String filePath, List<String[]> rows) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for(String[] row : rows) {
                writer.write(String.join(",", row));
                writer.write("\n");
            }
        }
    }
}