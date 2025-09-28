package metrics.algoritm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvWriteTest {

    @Test
    void writesCsvFileWithCorrectContent() throws IOException {
        // Arrange: Create temporary file
        Path tempFile = Files.createTempFile("metrics", ".csv");

        // Sample data
        List<String[]> rows = List.of(
                new String[]{"n", "comparisons", "allocations", "depth"},
                new String[]{"10", "12", "6", "3"}
        );

        // Act: Write data
        CsvWrite.write(tempFile.toString(), rows);

        // Assert: Read and verify contents
        String content = Files.readString(tempFile);
        assertTrue(content.contains("n,comparisons,allocations,depth"), "Header row missing or incorrect");
        assertTrue(content.contains("10,12,6,3"), "Data row missing or incorrect");

        // Cleanup
        Files.deleteIfExists(tempFile);
    }
}
