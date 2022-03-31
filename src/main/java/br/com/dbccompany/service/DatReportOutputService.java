package br.com.dbccompany.service;

import br.com.dbccompany.model.Salesman;
import br.com.dbccompany.model.calculations.SaleTotalCalculationDTO;
import br.com.dbccompany.model.file.ProcessedDatFileDTO;
import br.com.dbccompany.model.report.ReportOutputDataDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class DatReportOutputService {

    private final SaleCalculationService saleCalculationService;
    private final SalesmanService salesmanService;

    public DatReportOutputService(SaleCalculationService saleCalculationService,
                                  SalesmanService salesmanService) {
        this.saleCalculationService = saleCalculationService;
        this.salesmanService = salesmanService;
    }

    public ReportOutputDataDTO processDatFilesInputsToReportOutput(List<ProcessedDatFileDTO> processedDatFilesList) {
        try {

            int salesmanQuantity = processedDatFilesList.stream()
                    .reduce(
                            0,
                            (quantity, processedDatFileDTO) -> quantity += processedDatFileDTO.getSalesmen().size(),
                            Integer::sum
                    );

            int clientsQuantity = processedDatFilesList.stream()
                    .reduce(
                            0,
                            (quantity, processedDatFileDTO) -> quantity += processedDatFileDTO.getSalesmen().size(),
                            Integer::sum
                    );

            SaleTotalCalculationDTO mostExpensiveSaleAllFiles = null;
            HashMap<String, BigDecimal> sumSalesAmountPerSalemanAllFiles = new HashMap<>();
            for (ProcessedDatFileDTO processedDatFileDTO : processedDatFilesList) {
                SaleTotalCalculationDTO mostExpensiveSale = this.saleCalculationService.findMostExpensiveSaleFromSaleList(processedDatFileDTO.getSales());

                if (mostExpensiveSaleAllFiles == null
                        || mostExpensiveSaleAllFiles.getTotal().compareTo(mostExpensiveSale.getTotal()) < 0) {
                    mostExpensiveSaleAllFiles = mostExpensiveSale;
                }

                HashMap<String, BigDecimal> sumSalesAmountPerSaleman = this.salesmanService.sumSaleAmountPerSalesmanFromSalesList(processedDatFileDTO.getSales());
                sumSalesAmountPerSaleman.forEach((key, value) -> sumSalesAmountPerSalemanAllFiles.merge(key, value, BigDecimal::add));
            }

            String worstSalesmanName = Collections.min(sumSalesAmountPerSalemanAllFiles.entrySet(), Map.Entry.comparingByValue()).getKey();
            Salesman worstSalesman = null;
            for (ProcessedDatFileDTO processedDatFileDTO : processedDatFilesList) {
                worstSalesman = this.salesmanService.findSalesmanFromListByName(processedDatFileDTO.getSalesmen(), worstSalesmanName);
            }

            return new ReportOutputDataDTO(
                    clientsQuantity,
                    salesmanQuantity,
                    mostExpensiveSaleAllFiles.getSale().getSaleId(),
                    worstSalesman
            );
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Não foi processar os dados de input para output | Motivo: %s", e.getCause()));
        }
    }

    public String createReportContentOutput(ReportOutputDataDTO reportOutputDataDTO) {
        String clientsQuantityText = String.format("Quantidade de clientes: %s", reportOutputDataDTO.getClientQuantity());
        String salesmanQuantityText = String.format("Quantidade de vendedores: %s", reportOutputDataDTO.getSalesmanQuantity());
        String mostExpensiveSaleText = String.format("ID da venda mais cara: %s", reportOutputDataDTO.getMostExpensiveSale());
        String worstSalesmanText = String.format(
                "Pior vendedor: CPF:%s, Nome: %s",
                reportOutputDataDTO.getWorstSalesman().getCpf(),
                reportOutputDataDTO.getWorstSalesman().getName()
        );

        return clientsQuantityText + "\n" +
                salesmanQuantityText + "\n" +
                mostExpensiveSaleText + "\n" +
                worstSalesmanText;
    }

}
