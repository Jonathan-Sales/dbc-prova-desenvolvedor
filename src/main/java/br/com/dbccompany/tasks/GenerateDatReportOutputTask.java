package br.com.dbccompany.tasks;

import br.com.dbccompany.file.DatFileReader;
import br.com.dbccompany.file.FileWriterUtils;
import br.com.dbccompany.model.file.DatFileDTO;
import br.com.dbccompany.model.file.ProcessedDatFileDTO;
import br.com.dbccompany.model.report.ReportOutputDataDTO;
import br.com.dbccompany.service.DatReportOutputService;
import br.com.dbccompany.service.ProcessDatFileContentService;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateDatReportOutputTask extends TimerTask {

    private final ProcessDatFileContentService processDatFileContentService;
    private final DatReportOutputService datReportOutputService;

    public GenerateDatReportOutputTask(ProcessDatFileContentService processDatFileContentService,
                                       DatReportOutputService datReportOutputService) {
        this.processDatFileContentService = processDatFileContentService;
        this.datReportOutputService = datReportOutputService;
    }

    @Override
    public void run() {
        try {
            String homepath = System.getProperty("user.home");
            String inputDirectory = homepath.concat("/data/in/");
            List<DatFileDTO> datFileDTOList = DatFileReader.readAllDatFilesFromDirectory(inputDirectory);
            if(!datFileDTOList.isEmpty()){
                List<ProcessedDatFileDTO> processedDatFilesList = this.processDatFileContentService.processDatFiles(datFileDTOList);
                ReportOutputDataDTO reportOutputDataDTO = this.datReportOutputService.processDatFilesInputsToReportOutput(processedDatFilesList);
                String reportContentOutput = this.datReportOutputService.createReportContentOutput(reportOutputDataDTO);

                String outputDirectory = homepath.concat("/data/out/");
                String outputFilename = "report_" + System.currentTimeMillis() + ".done.dat";
                FileWriterUtils.createDatFileInDirectory(outputDirectory, outputFilename, reportContentOutput);
                FileUtils.cleanDirectory(new File(inputDirectory));

                List<String> processedFilenamesList = datFileDTOList.stream()
                        .map(DatFileDTO::getFilename)
                        .collect(Collectors.toList());
                System.out.println("Arquivos processados: " + String.join(",", processedFilenamesList));
            }
        } catch (Exception e) {
            System.err.println(String.format("Não foi possível gerar o relatório | Motivo: %s", e.getMessage()));
        }
    }
}
