package com.algaworks.algafood.infrastructure.service.report;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.service.VendaQueryService;
import com.algaworks.algafood.domain.service.VendaReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class PdfVendaReportService implements VendaReportService {

    @Autowired
    private VendaQueryService vendaQueryService;

    @Override
    public byte[] emitirVendaDiaria(VendaDiariaFilter filtro, String timeOffSet) {

        try {
            var inputStream = this.getClass().getResourceAsStream("/relatorios/vendas-diarias.jrxml");
            if (inputStream == null) {
                throw new IllegalStateException("Relatório vendas-diarias.jrxml não encontrado em /relatorios");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            var parametros = new HashMap<String, Object>();
            parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));

            var vendaDiarias = vendaQueryService.consultaVendaDiarias(filtro, timeOffSet);
            var datasource = new JRBeanCollectionDataSource(vendaDiarias);

            var jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, datasource);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e ){
            throw new ReportException("Não foi possivel emitir relatórios de vendas diárias", e);
        }

    }
}
