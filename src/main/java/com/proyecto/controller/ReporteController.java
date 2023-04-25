package com.proyecto.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/reportes")
public class ReporteController {

    //Para tener acceso a la conexiòn con la base de datos...
    @Autowired
    DataSource datasource;

    @GetMapping("/principal")
    public String principal() {
        return "/reportes/principal";
    }

    @GetMapping("/Inventario")
    public ResponseEntity<Resource> reporteProductos(@RequestParam String tipo) throws IOException {
        //Por desarrollar

        //Esto espara definir los paràmetros que se pasan al reporte cliente
        Map<String, Object> parametros = new HashMap();
        parametros.put("titulo", "Administracion");
        var reporte = "Inventario";
        return reportePrivado(reporte, parametros, tipo);
    }
        @GetMapping("/Proveedores")
    public ResponseEntity<Resource> reporteProveedores(@RequestParam String tipo) throws IOException {
        //Por desarrollar

        //Esto espara definir los paràmetros que se pasan al reporte cliente
        Map<String, Object> parametros = new HashMap();
        parametros.put("titulos", "Gerentes");
        var reporte = "Proveedores";
        return reportePrivado(reporte, parametros, tipo);
    }
           @GetMapping("/ListadoEmpleados")
    public ResponseEntity<Resource> reporteEmpleados(@RequestParam String tipo) throws IOException {
        //Por desarrollar

        //Esto espara definir los paràmetros que se pasan al reporte cliente
        Map<String, Object> parametros = new HashMap();
        parametros.put("titulo", "Axel");
        var reporte = "ListadoEmpleados";
        return reportePrivado(reporte, parametros, tipo);
    }

    @GetMapping("/Reclamos")
    public ResponseEntity<Resource> reporteReclamos(@RequestParam String tipo) throws IOException {
        //Por desarrollar

        //Esto espara definir los paràmetros que se pasan al reporte cliente
        Map<String, Object> parametros = new HashMap();
        parametros.put("titulo", "Axel");
        var reporte = "Reclamos";
        return reportePrivado(reporte, parametros, tipo);
    }

    
    @GetMapping("/ventas")
    public ResponseEntity<Resource> reporteVentas(@RequestParam String tipo) throws IOException {
        //Por desarrollar
        var reporte="ventas";
        return reportePrivado(reporte, null, tipo);
    }

    private ResponseEntity<Resource> reportePrivado(
            String reporte,
            Map<String, Object> parametros,
            String tipo) throws IOException {
        try {

            String estilo = "";
            if ("vPdf".equals(tipo)) {
                estilo = "inline; ";
            } else {
                estilo = "attachment; ";
            }

            //La ruta dentro de "default package"
            String reportePath = "reportes";
            //En salida quedarà el reporte ya generado...
            ByteArrayOutputStream salida = new ByteArrayOutputStream();

            //Se define el lugar y acceso al archivo .jasper
            ClassPathResource fuente
                    = new ClassPathResource(
                            reportePath
                            + File.separator
                            + reporte
                            + ".jasper");

            //Un objeto para leer efectivamente el reporte
            InputStream elReporte = fuente.getInputStream();

            //Se crea el reporte como tal
            var reporteJasper
                    = JasperFillManager
                            .fillReport(
                                    elReporte,
                                    parametros,
                                    datasource.getConnection());
            MediaType mediaType = null;
            String archivoSalida = "";
            byte[] data;
            if ("Pdf".equals(tipo) || "vPdf".equals(tipo)) {
                JasperExportManager.exportReportToPdfStream(reporteJasper, salida);
                mediaType = MediaType.APPLICATION_PDF;
                archivoSalida = reporte + ".pdf";
            } else if ("Xls".equals(tipo)) {
                JRXlsxExporter exportador = new JRXlsxExporter();
                exportador.setExporterInput(
                        new SimpleExporterInput(
                                reporteJasper));
                exportador.setExporterOutput(
                        new SimpleOutputStreamExporterOutput(
                                salida));
                SimpleXlsxReportConfiguration configuracion=
                        new SimpleXlsxReportConfiguration();
                configuracion.setDetectCellType(true);
                configuracion.setCollapseRowSpan(true);
                exportador.setConfiguration(configuracion);
                exportador.exportReport();
                mediaType = MediaType.APPLICATION_OCTET_STREAM;
                archivoSalida = reporte + ".xlsx";
            } else if ("Csv".equals(tipo)) {
                JRCsvExporter exportador = new JRCsvExporter();
                exportador.setExporterInput(
                        new SimpleExporterInput(
                                reporteJasper));
                exportador.setExporterOutput(
                        new SimpleWriterExporterOutput(
                                salida));
                
                exportador.exportReport();
                mediaType = MediaType.TEXT_PLAIN;
                archivoSalida = reporte + ".csv";
            }

            data = salida.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Disposition",
                    estilo + "filename=\"" + archivoSalida + "\"");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(data.length)
                    .contentType(mediaType)
                    .body(
                            new InputStreamResource(
                                    new ByteArrayInputStream(data)));

        } catch (SQLException | JRException e) {
            return null;
        }

    }
}
