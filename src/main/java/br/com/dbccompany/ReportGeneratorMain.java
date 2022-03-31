package br.com.dbccompany;

import br.com.dbccompany.service.DatReportOutputService;
import br.com.dbccompany.service.ProcessDatFileContentService;
import br.com.dbccompany.service.SaleCalculationService;
import br.com.dbccompany.service.SalesmanService;
import br.com.dbccompany.tasks.GenerateDatReportOutputTask;

import java.util.Timer;

public class ReportGeneratorMain {

    public static void main(String[] args) {
        GenerateDatReportOutputTask datReportOutputService = new GenerateDatReportOutputTask(
                new ProcessDatFileContentService(),
                new DatReportOutputService(
                        new SaleCalculationService(),
                        new SalesmanService()
                )
        );

        Timer generateDatReportTimer = new Timer("DatReportTimer");
        long intervalBetweenTasks = 1000;
        generateDatReportTimer.schedule(datReportOutputService, intervalBetweenTasks, intervalBetweenTasks);
    }

}
