package br.com.dbccompany.faker;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileFaker {

    private static final String defaultDatFileContent = "001ç1234567891234çPedroç50000\n" +
            "001ç3245678865434çPauloç40000.99\n" +
            "002ç2345675434544345çJose da SilvaçRural\n" +
            "002ç2345675433444345çEduardo PereiraçRural\n" +
            "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
            "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo";

    private static void createFileInDirectory(String filePath, String content) {
        try {
            String normalizedFilename = FilenameUtils.normalize(filePath);
            File testsFile = new File(normalizedFilename);
            FileUtils.write(testsFile, content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.printf("Não foi possível criar o arquivo no diretório: %s | Motivo: %s", filePath, e.getCause());
        }

    }

    public static void createDatFileInDirectory(String directory) {
        String filePath = directory.concat("//testFile.dat");
        createFileInDirectory(filePath, defaultDatFileContent);
    }

    public static void createInvalidFileInDirectory(String directory) {
        String filePath = directory.concat("//testFile.abc");
        createFileInDirectory(filePath, defaultDatFileContent);
    }

}
