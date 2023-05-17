package com.example.app.PDF;

import com.example.app.Models.Vehiculo;
import com.example.app.Repositories.VehiculoRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/pdfVehiculoList")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class PDFListaVehiculos {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @GetMapping
    public ResponseEntity downloadPdf(HttpServletResponse response,
                                      @RequestParam(defaultValue = "1") Long tipoId
    ) throws Exception {

        Document document = new Document(PageSize.LETTER.rotate());
        document.setMargins(5, 5, 70, 70);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());


        if (tipoId == 1) {
            MembreteHeaderiText header = new MembreteHeaderiText();
            writer.setPageEvent(header);
        } else {
            MembreteHeaderiText2 header = new MembreteHeaderiText2();
            writer.setPageEvent(header);
        }


        String verdanapath = "src/main/java/com/example/app/PDF/files/verdana.ttf";
        BaseFont verdana = BaseFont.createFont(verdanapath, "Cp1252", true);
        String verdanaBpath = "src/main/java/com/example/app/PDF/files/verdanab.ttf";
        BaseFont verdanaB = BaseFont.createFont(verdanaBpath, "Cp1252", true);

        Paragraph par1 = new Paragraph();
        Font fontitulo = new Font(verdanaB, 9, Font.NORMAL, BaseColor.BLACK);
        Font fontfecha = new Font();
        fontfecha.setSize(8);

        Font font9 = new Font(verdanaB, 9, Font.NORMAL, BaseColor.BLACK);

        Font font9N = new Font(verdana, 8, Font.NORMAL, BaseColor.BLACK);

        Font font8 = new Font(verdanaB, 8, Font.NORMAL, BaseColor.BLACK);

        Font font8N = new Font(verdana, 8, Font.NORMAL, BaseColor.BLACK);

        Font font7 = new Font(verdanaB, 7, Font.NORMAL, BaseColor.BLACK);

        Font font7N = new Font(verdana, 7, Font.NORMAL, BaseColor.BLACK);

        Font font6 = new Font(verdana, 5, Font.BOLD, BaseColor.BLACK);

        Font font6N = new Font(verdanaB, 6, Font.NORMAL, BaseColor.BLACK);

        Font font5N = new Font(verdanaB, 5, Font.NORMAL, BaseColor.BLACK);

        Font font5 = new Font(verdana, 5, Font.NORMAL, BaseColor.BLACK);


        BaseColor coloresCategoria1[] = {WebColors.getRGBColor("#84cc16"), WebColors.getRGBColor("#818cf8"), WebColors.getRGBColor("#fb923c"), WebColors.getRGBColor("#e879f9"), WebColors.getRGBColor("#c084fc"), WebColors.getRGBColor("#2dd4bf"), WebColors.getRGBColor("#38bdf8")};
        BaseColor coloresCategoria2[] = {WebColors.getRGBColor("#a3e635"), WebColors.getRGBColor("#a5b4fc"), WebColors.getRGBColor("#fdba74"), WebColors.getRGBColor("#f0abfc"), WebColors.getRGBColor("#d8b4fe"), WebColors.getRGBColor("#5eead4"), WebColors.getRGBColor("#7dd3fc")};
        BaseColor coloresCategoria3[] = {WebColors.getRGBColor("#84cc16"), WebColors.getRGBColor("#6366f1"), WebColors.getRGBColor("#f97316"), WebColors.getRGBColor("#e879f9"), WebColors.getRGBColor("#a855f7"), WebColors.getRGBColor("#14b8a6"), WebColors.getRGBColor("#0ea5e9")};
        BaseColor coloresCategoria4[] = {WebColors.getRGBColor("#a3e635"), WebColors.getRGBColor("#818cf8"), WebColors.getRGBColor("#fb923c"), WebColors.getRGBColor("#f0abfc"), WebColors.getRGBColor("#c084fc"), WebColors.getRGBColor("#2dd4bf"), WebColors.getRGBColor("#7dd3fc")};


        PdfPTable tablainicial = new PdfPTable(1);
        tablainicial.setWidthPercentage(155);

        Phrase resumen = new Phrase();
        PdfPCell celli = new PdfPCell();


        celli = new PdfPCell(resumen);
        celli.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celli.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);

        BaseColor myColor = WebColors.getRGBColor("#E0E0E0");
        BaseColor myColor2 = WebColors.getRGBColor("#E0E0E0");

        par1.setMultipliedLeading(0.8f);
        //par1.add(new Phrase("Secretaría de Proteción Civil" +"\n" + "Unidad Administrativa" +"\n" + "Departamento de Recursos Materiales y Servicios Generales" +"\n" ,font7N));
        //par1.add(new Phrase("Plantilla Vehicular del año",font7));

        par1.setAlignment(Element.ALIGN_CENTER);


        float[] column;
        if (tipoId == 1) {
            column = new float[]{0.3f, 0.5f, 0.6f, 0.7f, 0.7f, 0.4f, 1f, 1f, 1f, 1f, 1f};
        } else {
            column = new float[]{0.3f, 0.5f, 0.6f, 0.7f, 0.7f, 0.7f, 0.7f, 1f, 1f, 1f, 1f};
        }

        PdfPTable table = new PdfPTable(column);
        table.setWidthPercentage(90);

        Paragraph par10 = new Paragraph("No", font5N);
        par10.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda10 = new PdfPCell(par10);
        celda10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda10.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda10.setBackgroundColor(myColor);
        table.addCell(celda10);

        if (tipoId == 1) {
            Paragraph par11 = new Paragraph("Placa", font5N);
            par11.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11 = new PdfPCell(par11);
            celda11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda11.setBackgroundColor(myColor);
            table.addCell(celda11);
        }
        if (tipoId == 2) {
            Paragraph par11 = new Paragraph("Matrícula", font5N);
            par11.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11 = new PdfPCell(par11);
            celda11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda11.setBackgroundColor(myColor);
            table.addCell(celda11);
        }

        Paragraph par12 = new Paragraph("No Económico", font5N);
        par12.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda12 = new PdfPCell(par12);
        celda12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda12.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda12.setBackgroundColor(myColor);
        table.addCell(celda12);


        Paragraph par13 = new Paragraph("Marca", font5N);
        par13.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda13 = new PdfPCell(par13);
        celda13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda13.setBackgroundColor(myColor);
        table.addCell(celda13);

        if (tipoId == 1) {
            Paragraph par14 = new Paragraph("Tipo", font5N);
            par14.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda14 = new PdfPCell(par14);
            celda14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda14.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda14.setBackgroundColor(myColor);
            table.addCell(celda14);
        }

        Paragraph par15 = new Paragraph("Modelo", font5N);
        par15.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda15 = new PdfPCell(par15);
        celda15.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda15.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda15.setBackgroundColor(myColor);
        table.addCell(celda15);

        Paragraph par16 = new Paragraph("No. Serie", font5N);
        par16.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda16 = new PdfPCell(par16);
        celda16.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda16.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda16.setBackgroundColor(myColor);
        table.addCell(celda16);

        if (tipoId == 2) {
            Paragraph par11 = new Paragraph("No. Motor", font5N);
            par11.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda11 = new PdfPCell(par11);
            celda11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda11.setBackgroundColor(myColor);
            table.addCell(celda11);
        }

        Paragraph par17 = new Paragraph("Área Responsable", font5N);
        par17.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda17 = new PdfPCell(par17);
        celda17.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda17.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda17.setBackgroundColor(myColor);
        table.addCell(celda17);

        Paragraph par18 = new Paragraph("Nombre Resguardante", font5N);
        par18.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda18 = new PdfPCell(par18);
        celda18.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda18.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda18.setBackgroundColor(myColor);
        table.addCell(celda18);


        Paragraph par19 = new Paragraph("Cargo", font5N);
        par19.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda19 = new PdfPCell(par19);
        celda19.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda19.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda19.setBackgroundColor(myColor);
        table.addCell(celda19);


        Paragraph par20 = new Paragraph("Ubicación", font5N);
        par20.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda20 = new PdfPCell(par20);
        celda20.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda20.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda20.setBackgroundColor(myColor);
        table.addCell(celda20);

        //Hacer el listado

        Pageable paging = PageRequest.of(0, 999, Sort.by(Sort.Direction.ASC, "noEconomico"));

        int size2 = vehiculoRepository.findByCategoria_TipoTransporte_id(tipoId).size();

        Page<Vehiculo> pageReps = vehiculoRepository.findByCategoria_TipoTransporte_id(tipoId, paging);

        for (int i = 0; i < size2; i++) {
            int id = i + 1;
            String placa;
            String noEconomico;
            String marca;
            String tipo;
            String modelo;
            String serie;
            String area;
            String nombreResguardante;
            String cargo;
            String ubicacion;
            String matricula;
            String noMotor;


            if (pageReps.getContent().get(i).getPlacas() == null) {
                placa = "EN TRAMITE";
            } else {
                placa = pageReps.getContent().get(i).getPlacas();
            }

            if (pageReps.getContent().get(i).getNoMatricula() == null) {
                matricula = "EN TRAMITE";
            } else {
                matricula = pageReps.getContent().get(i).getNoMatricula();
            }


            if (pageReps.getContent().get(i).getNoEconomico() == null) {
                noEconomico = "N/A";
            } else {
                noEconomico = pageReps.getContent().get(i).getNoEconomico();
            }

            if (pageReps.getContent().get(i).getMarca() == null) {
                marca = "N/A";
            } else {
                marca = pageReps.getContent().get(i).getMarca();
            }


            if (pageReps.getContent().get(i).getTipoVehiculo() == null) {
                tipo = "N/A";
            } else {
                tipo = pageReps.getContent().get(i).getTipoVehiculo();
            }


            if (pageReps.getContent().get(i).getModelo() == null) {
                modelo = "N/A";
            } else {
                modelo = pageReps.getContent().get(i).getModelo().toString();
            }

            if (pageReps.getContent().get(i).getNoSerie() == null) {
                serie = "N/A";
            } else {
                serie = pageReps.getContent().get(i).getNoSerie();
            }

            if (pageReps.getContent().get(i).getNoMotor() == null) {
                noMotor = "N/A";
            } else {
                noMotor = pageReps.getContent().get(i).getNoMotor();
            }

            if (pageReps.getContent().get(i).getArea().getNombreArea() == null) {
                area = "N/A";
            } else {
                area = pageReps.getContent().get(i).getArea().getNombreArea().toString();
            }

            if (pageReps.getContent().get(i).getResguardante().getNombre() == null || pageReps.getContent().get(i).getResguardante() == null) {
                nombreResguardante = "N/A";
            } else {
                nombreResguardante = pageReps.getContent().get(i).getResguardante().getNombre().toString();
            }

            if (pageReps.getContent().get(i).getResguardante().getCargo() == null || pageReps.getContent().get(i).getResguardante() == null) {
                cargo = "N/A";
            } else {
                cargo = pageReps.getContent().get(i).getResguardante().getCargo().toString();
            }

            if (pageReps.getContent().get(i).getUbicacion() == null) {
                ubicacion = "N/A";
            } else {
                ubicacion = pageReps.getContent().get(i).getUbicacion().toString()+", "+ pageReps.getContent().get(i).getMunicipio().getMunicipio();
            }

            Paragraph noEconomicoColor = new Paragraph(noEconomico, font5N);
            PdfPCell celdaColor = new PdfPCell(noEconomicoColor);
            celdaColor.setBackgroundColor(coloresCategoria4[pageReps.getContent().get(i).getCategoria().getId().intValue() - 1]);


            //agregar contenido a la tabla
            table.addCell(new Phrase(String.valueOf(id), font5N));
            if (tipoId == 1) {
                table.addCell(new Phrase(placa, font5N));
            }
            if (tipoId == 2) {
                table.addCell(new Phrase(matricula, font5N));
            }
            table.addCell(celdaColor);
            table.addCell(new Phrase(marca, font5));
            if (tipoId == 1) {
                table.addCell(new Phrase(tipo, font5));
            }
            table.addCell(new Phrase(modelo, font5));
            table.addCell(new Phrase(serie, font5));
            if (tipoId == 2) {
                table.addCell(new Phrase(noMotor, font5));
            }
            table.addCell(new Phrase(area, font5));
            table.addCell(new Phrase(nombreResguardante, font5));
            table.addCell(new Phrase(cargo, font5));
            table.addCell(new Phrase(ubicacion, font5));


        }

        float[] column2 = {.5f, 1f, .5f, 1f, .5f, 1f, .5f, 1f, .5f, 1f, .5f, 1f};
        PdfPTable table2 = new PdfPTable(column2);

        PdfPCell cellc1 = new PdfPCell();
        cellc1.setBackgroundColor(coloresCategoria4[0]);
        cellc1.setBorder(0);
        PdfPCell cellc2 = new PdfPCell();
        cellc2.setBackgroundColor(coloresCategoria4[1]);
        cellc2.setBorder(0);
        PdfPCell cellc3 = new PdfPCell();
        cellc3.setBackgroundColor(coloresCategoria4[2]);
        cellc3.setBorder(0);
        PdfPCell cellc4 = new PdfPCell();
        cellc4.setBackgroundColor(coloresCategoria4[3]);
        cellc4.setBorder(0);
        PdfPCell cellc5 = new PdfPCell();
        cellc5.setBackgroundColor(coloresCategoria4[4]);
        cellc5.setBorder(0);
        PdfPCell cellc6 = new PdfPCell();
        cellc6.setBackgroundColor(coloresCategoria4[5]);
        cellc6.setBorder(0);

        Paragraph parc1 = new Paragraph("Ataque Rápido", font5);
        PdfPCell cellc1b = new PdfPCell(parc1);
        cellc1b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc1b.setBorder(0);

        Paragraph parc2 = new Paragraph("Caja Seca", font5);
        PdfPCell cellc2b = new PdfPCell(parc2);
        cellc2b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc2b.setBorder(0);

        Paragraph parc3 = new Paragraph("Coche", font5);
        PdfPCell cellc3b = new PdfPCell(parc3);
        cellc3b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc3b.setBorder(0);

        Paragraph parc4 = new Paragraph("Cuatrimoto", font5);
        PdfPCell cellc4b = new PdfPCell(parc4);
        cellc4b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc4b.setBorder(0);

        Paragraph parc5 = new Paragraph("PickUp", font5);
        PdfPCell cellc5b = new PdfPCell(parc5);
        cellc5b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc5b.setBorder(0);

        Paragraph parc6 = new Paragraph("Pipa", font5);
        PdfPCell cellc6b = new PdfPCell(parc6);
        cellc6b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc6b.setBorder(0);

        table2.addCell(cellc1);
        table2.addCell(cellc1b);
        table2.addCell(cellc2);
        table2.addCell(cellc2b);
        table2.addCell(cellc3);
        table2.addCell(cellc3b);
        table2.addCell(cellc4);
        table2.addCell(cellc4b);
        table2.addCell(cellc5);
        table2.addCell(cellc5b);
        table2.addCell(cellc6);
        table2.addCell(cellc6b);


        float[] column3 = {.05f, 1f};
        PdfPTable table3 = new PdfPTable(column3);
        PdfPCell cellc7 = new PdfPCell();
        cellc7.setBackgroundColor(coloresCategoria4[6]);
        cellc7.setBorder(0);

        Paragraph parc7 = new Paragraph("Lancha", font5);
        PdfPCell cellc7b = new PdfPCell(parc7);
        cellc7b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cellc7b.setBorder(0);

        table3.addCell(cellc7);
        table3.addCell(cellc7b);
        //abrir documento para escribir todas las partes y cerrar documento
        document.open();
        document.add(par1);

        document.add(table);
        document.add(Chunk.NEWLINE);
        if (tipoId == 1) {
            document.add(table2);
        } else {
            document.add(table3);
        }
        document.close();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"plantilla.pdf\"").body(document);
    }
}