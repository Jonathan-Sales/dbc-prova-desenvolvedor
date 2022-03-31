package br.com.dbccompany.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterUtils {

    public static void createDatFileInDirectory(String directoryPath, String filename, String content) {
        String filePath = directoryPath.concat(filename);
        try {
            Files.createDirectories(Paths.get(directoryPath));

            String normalizedFilename = FilenameUtils.normalize(filePath);
            File testsFile = new File(normalizedFilename);
            FileUtils.write(testsFile, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.printf("Não foi possível criar o arquivo no diretório: %s | Motivo: %s", filePath, e.getMessage());
        }
    }

}
