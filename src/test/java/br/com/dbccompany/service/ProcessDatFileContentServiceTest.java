package br.com.dbccompany.service;

import br.com.dbccompany.faker.DatFileFaker;
import br.com.dbccompany.model.file.DatFileDTO;
import br.com.dbccompany.model.file.ProcessedDatFileDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProcessDatFileContentServiceTest {

    private ProcessDatFileContentService processDatFileContentService = new ProcessDatFileContentService();

    @Test
    public void shouldConvertDatFileLinesToProcessedDatFileDTOWithSuccess() {
        List<DatFileDTO> datFileLines = DatFileFaker.getValidDatFileDTOList();

        List<ProcessedDatFileDTO> processedDatFile = Assertions.assertDoesNotThrow(
                () -> this.processDatFileContentService.processDatFiles(datFileLines)
        );
        Assertions.assertNotNull(processedDatFile);
        Assertions.assertFalse(processedDatFile.isEmpty());
    }


}
