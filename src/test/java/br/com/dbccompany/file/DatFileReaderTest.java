package br.com.dbccompany.file;

import br.com.dbccompany.faker.FileFaker;
import br.com.dbccompany.model.file.DatFileDTO;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DatFileReaderTest {

    private final DatFileReader datFileReader = new DatFileReader();
    private final String directoryPath = "./data/in";

    @BeforeEach
    public void setUp() {
        FileFaker.createDatFileInDirectory(directoryPath);
        FileFaker.createInvalidFileInDirectory(directoryPath);
    }

    @Test
    public void shouldReadDatFilesFromDirectoryWithSuccess() {
        List<DatFileDTO> files = Assertions.assertDoesNotThrow(
                () -> this.datFileReader.readAllDatFilesFromDirectory(directoryPath)
        );

        boolean allFilesMatchDatExtension = files.stream().allMatch(file -> file.getFilename().endsWith(".dat"));
        Assertions.assertTrue(allFilesMatchDatExtension);

        boolean filesContentIsNotEmpty = files.stream().noneMatch(file -> file.getLines().isEmpty());
        Assertions.assertTrue(filesContentIsNotEmpty);
    }

    @Test
    public void shouldIgnoreOtherFilesThatNotWithDatExtension() {
        List<DatFileDTO> files = Assertions.assertDoesNotThrow(
                () -> this.datFileReader.readAllDatFilesFromDirectory(directoryPath)
        );

        boolean anyFileWithNotDatExtension = files.stream().anyMatch(file -> !file.getFilename().endsWith(".dat"));
        Assertions.assertFalse(anyFileWithNotDatExtension);
    }

    @Test
    public void shouldThrowsErrorWhenDirectoryNotExists() throws IOException {
        FileUtils.deleteDirectory(new File(directoryPath));

        Assertions.assertThrows(IOException.class, () -> this.datFileReader.readAllDatFilesFromDirectory(directoryPath));
    }

    @AfterEach
    public void setDown() throws IOException {
        File directoryFile = new File(directoryPath);
        if (FileUtils.isDirectory(directoryFile)) {
            FileUtils.cleanDirectory(directoryFile);
        }
    }

}
