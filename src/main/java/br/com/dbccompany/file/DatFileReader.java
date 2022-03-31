package br.com.dbccompany.file;

import br.com.dbccompany.model.file.DatFileDTO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DatFileReader {

    public static List<DatFileDTO> readAllDatFilesFromDirectory(String directoryPath) throws IOException {
        List<DatFileDTO> filesWithContent = new ArrayList<>();

        File directoryFile = new File(directoryPath);
        if (!directoryFile.exists()) {
            throw new IOException(String.format("O diretório %s não existe", directoryPath));
        }

        Collection<File> files = FileUtils.listFiles(directoryFile, new String[]{"dat"}, false);
        files.forEach(file -> {
            try {
                List<String> fileContent = FileUtils.readLines(file, StandardCharsets.UTF_8);
                filesWithContent.add(
                        new DatFileDTO(file.getName(), fileContent)
                );
            } catch (IOException e) {
                System.err.println(String.format("Não foi possível ler o arquivo: %s | Motivo: %s", file.getName(), e.getMessage()));
            }
        });

        return filesWithContent;
    }
}
