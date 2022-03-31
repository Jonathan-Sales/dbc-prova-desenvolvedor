package br.com.dbccompany.service;

import br.com.dbccompany.model.Client;
import br.com.dbccompany.model.Sale;
import br.com.dbccompany.model.Salesman;
import br.com.dbccompany.model.enums.DatFileLineTypeEnum;
import br.com.dbccompany.model.file.DatFileDTO;
import br.com.dbccompany.model.file.ProcessedDatFileDTO;

import java.util.ArrayList;
import java.util.List;

public class ProcessDatFileContentService {

    public List<ProcessedDatFileDTO> processDatFiles(List<DatFileDTO> datFilesDTO) {
        List<ProcessedDatFileDTO> processedDatFilesList = new ArrayList<>();
        datFilesDTO.parallelStream().forEach(datFileDTO -> {
            processedDatFilesList.add(
                    processDatFileLines(datFileDTO.getFilename(), datFileDTO.getLines())
            );
        });

        return processedDatFilesList;
    }

    private ProcessedDatFileDTO processDatFileLines(String filename, List<String> lines){
        ProcessedDatFileDTO processedDatFileDTO = new ProcessedDatFileDTO(filename);
        lines.forEach(line -> {
            String lineTypeId = line.substring(0, 3);
            DatFileLineTypeEnum lineType = DatFileLineTypeEnum.getLineTypeFromString(lineTypeId);
            Object convertedLine = lineType.getContentConverterStrategy().convertContentToModel(line);
            switch (lineType) {
                case SALESMAN:
                    processedDatFileDTO.getSalesmen().add((Salesman) convertedLine);
                    break;
                case CLIENT:
                    processedDatFileDTO.getClients().add((Client) convertedLine);
                    break;
                case SALE:
                    processedDatFileDTO.getSales().add((Sale) convertedLine);
                    break;
            }
        });
        return processedDatFileDTO;
    }

}
