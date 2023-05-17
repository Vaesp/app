package com.example.app.PDF;

import com.example.app.Repositories.Tramites.ResguardoTemporalRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/pdfResguardoTemporal")
//@PreAuthorize("hasRole('USER  ') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class PDFResguardoTemporal {

    @Autowired
    ResguardoTemporalRepository resguardoTemporalRepository;

    @GetMapping
    public ResponseEntity downloadPdf(HttpServletResponse response,
                                      Long id) throws Exception {

        Document document = new Document(PageSize.LETTER);
        document.setMargins(35, 35, 100, 10);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        MembreteHeaderiTextResguardo header = new MembreteHeaderiTextResguardo();
        writer.setPageEvent(header);
        //writer.setPageEvent(footer);

        BaseFont base = BaseFont.createFont("src/main/java/com/example/app/PDF/files/wingding.ttf", BaseFont.IDENTITY_H, false);
        Font font = new Font(base, 10f, Font.BOLD);
        char checked = '\u00FE';
        char unchecked = '\u00A8';

        String verdanapath = "src/main/java/com/example/app/PDF/files/verdana.ttf";
        BaseFont verdana = BaseFont.createFont(verdanapath, "Cp1252", true);
        String verdanaBpath = "src/main/java/com/example/app/PDF/files/verdanab.ttf";
        BaseFont verdanaB = BaseFont.createFont(verdanaBpath, "Cp1252", true);

        Image img = Image.getInstance("src/main/java/com/example/app/PDF/img/auto.jpg");

        img.scaleToFit(120f, 120f);


        Paragraph par1 = new Paragraph();
        Paragraph par2 = new Paragraph();
        Font fontitulo = new Font(verdanaB, 9, Font.NORMAL, BaseColor.BLACK);
        Font fontfecha = new Font();
        fontfecha.setSize(8);

        //ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("RESGUARDO TEMPORAL2", fontitulo), 45,680,0);
        Font fontitulo2 = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);

        Font font9 = new Font(verdanaB, 9, Font.NORMAL, BaseColor.BLACK);

        Font font9N = new Font(verdana, 8, Font.NORMAL, BaseColor.BLACK);

        Font font8 = new Font(verdanaB, 8, Font.NORMAL, BaseColor.BLACK);

        Font font8N = new Font(verdana, 8, Font.NORMAL, BaseColor.BLACK);

        Font font7 = new Font(verdanaB, 7, Font.NORMAL, BaseColor.BLACK);

        Font font7N = new Font(verdana, 7, Font.NORMAL, BaseColor.BLACK);

        Font font6 = new Font(verdana, 5, Font.BOLD, BaseColor.BLACK);

        Font font6N = new Font(verdanaB, 6, Font.NORMAL, BaseColor.BLACK);

        Font font5N = new Font(verdanaB, 5, Font.NORMAL, BaseColor.BLACK);


        PdfPTable tablainicial = new PdfPTable(1);
        tablainicial.setWidthPercentage(105);

        Phrase resumen = new Phrase();
        PdfPCell celli = new PdfPCell();


        celli = new PdfPCell(resumen);
        celli.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celli.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);

        BaseColor myColor = WebColors.getRGBColor("#E0E0E0");
        BaseColor myColor2 = WebColors.getRGBColor("#E0E0E0");


        float[] column = {0.3f, 1f};
        PdfPTable table = new PdfPTable(column);
        table.setWidthPercentage(100);

        String foliodata;
        String comodatario;
        String comodato;
        String mun;
        String vehiculo;
        String noEconomico;
        String motivo;
        String fechasalida;
        LocalDate fechasalida2;
        String fechallegada;
        LocalDate fechallegada2;
        String kmSalida;
        String kmLlegada;

        if (resguardoTemporalRepository.findById(id).get().getFolio() == null) {
            foliodata = "N/A";
        } else {
            foliodata = resguardoTemporalRepository.findById(id).get().getFolio();
        }

        par1.setMultipliedLeading(0.8f);
        par1.add(new Phrase("FOLIO: " + foliodata, fontitulo2));
        par1.setAlignment(Element.ALIGN_RIGHT);
        par1.setIndentationRight(-4);
        par1.add(new Phrase(Chunk.NEWLINE));

        String Stringpar50;

        if (resguardoTemporalRepository.findById(id).get().getComodatario().equals(false) || resguardoTemporalRepository.findById(id).get().getComodatario() == null) {
            Stringpar50 = "RESGUARDANTE";
        } else {
            Stringpar50 = "COMODATARIO";
        }

        Paragraph par50 = new Paragraph(Stringpar50, font8);

        par50.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda50 = new PdfPCell(par50);
        celda50.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda50.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda50.setFixedHeight(15);
        celda50.setBackgroundColor(myColor);
        table.addCell(celda50);

        if (resguardoTemporalRepository.findById(id).get().getSolicitante() == null) {
            comodatario = "N/A";
        } else {
            comodatario = resguardoTemporalRepository.findById(id).get().getSolicitante().toString();
        }
        Paragraph par51 = new Paragraph(comodatario, font8N);
        par51.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda51 = new PdfPCell(par51);
        celda51.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda51.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda51.setFixedHeight(15);
        table.addCell(celda51);


        String Stringpar53;

        if (!resguardoTemporalRepository.findById(id).get().getComodatario() || resguardoTemporalRepository.findById(id).get().getComodatario() == null) {
            Stringpar53 = "NÚMERO DE OFICIO";
        } else {
            Stringpar53 = "No DE COMODATO";
        }

        Paragraph par53 = new Paragraph(Stringpar53, font8);
        par53.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda53 = new PdfPCell(par53);
        celda53.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda53.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda53.setFixedHeight(15);
        celda53.setBackgroundColor(myColor);
        table.addCell(celda53);

        if (resguardoTemporalRepository.findById(id).get().getNoOficio() == null) {
            comodato = "N/A";
        } else {
            comodato = resguardoTemporalRepository.findById(id).get().getNoOficio().toString();
        }
        Paragraph par54 = new Paragraph(comodato, font8N);
        par54.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda54 = new PdfPCell(par54);
        celda54.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda54.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda54.setFixedHeight(15);
        table.addCell(celda54);


        Paragraph par55 = new Paragraph("DESTINO", font8);
        par55.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda55 = new PdfPCell(par55);
        celda55.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda55.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda55.setFixedHeight(15);
        celda55.setBackgroundColor(myColor);
        table.addCell(celda55);

        if (resguardoTemporalRepository.findById(id).get().getMunicipio().getMunicipio() == null) {
            mun = "N/A";
        } else {
            mun = resguardoTemporalRepository.findById(id).get().getMunicipio().getMunicipio().toString();
        }
        Paragraph par56 = new Paragraph(mun, font8N);
        par56.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda56 = new PdfPCell(par56);
        celda56.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda56.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda56.setFixedHeight(15);
        table.addCell(celda56);


        Paragraph par57 = new Paragraph("VEHÍCULO", font8);
        par57.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda57 = new PdfPCell(par57);
        celda57.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda57.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda57.setFixedHeight(15);
        celda57.setBackgroundColor(myColor);
        table.addCell(celda57);


        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getNombre() == null) {
            vehiculo = "N/A";
        } else {
            vehiculo = resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getNombre().toString();
        }
        Paragraph par58 = new Paragraph(vehiculo, font8N);
        par58.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda58 = new PdfPCell(par58);
        celda58.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda58.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda58.setFixedHeight(15);
        table.addCell(celda58);


        Paragraph par59 = new Paragraph("No ECONÓMICO", font8);
        par59.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda59 = new PdfPCell(par59);
        celda59.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda59.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda59.setFixedHeight(15);
        celda59.setBackgroundColor(myColor);
        table.addCell(celda59);

        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getNoEconomico() == null) {
            noEconomico = "N/A";
        } else {
            noEconomico = resguardoTemporalRepository.findById(id).get().getVehiculo().getNoEconomico().toString();
        }
        Paragraph par60 = new Paragraph(noEconomico, font8N);
        par60.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda60 = new PdfPCell(par60);
        celda60.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda60.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda60.setFixedHeight(15);
        table.addCell(celda60);

        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() == 1) {
            Paragraph par59b = new Paragraph("MOTIVO", font8);
            par59b.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda59b = new PdfPCell(par59b);
            celda59b.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            celda59b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda59b.setFixedHeight(15);
            celda59b.setBackgroundColor(myColor);
            table.addCell(celda59b);

            if (resguardoTemporalRepository.findById(id).get().getMotivo() == null) {
                motivo = "N/A";
            } else {
                motivo = resguardoTemporalRepository.findById(id).get().getMotivo().toString();
            }
            Paragraph par60b = new Paragraph(motivo, font8N);
            par60b.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda60b = new PdfPCell(par60b);
            celda60b.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            celda60b.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda60b.setFixedHeight(15);
            table.addCell(celda60b);
        }


        Paragraph par61 = new Paragraph("FECHA DE SALIDA", font8);
        par61.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda61 = new PdfPCell(par61);
        celda61.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda61.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda61.setFixedHeight(15);
        celda61.setBackgroundColor(myColor);
        table.addCell(celda61);

        if (resguardoTemporalRepository.findById(id).get().getFechaSalida() == null) {
            fechasalida = "N/A";
        } else {
            fechasalida2 = resguardoTemporalRepository.findById(id).get().getFechaSalida();
            Integer dia = fechasalida2.getDayOfMonth();
            String diaformato = String.format("%02d", dia);
            Integer mes= fechasalida2.getMonthValue();
            String mesformato = String.format("%02d", mes);
            Integer year= fechasalida2.getYear();
            fechasalida=diaformato  +"/"+mesformato+"/"+String.valueOf(year);



            //fechasalida = resguardoTemporalRepository.findById(id).get().getFechaSalida().toString();
        }
        Paragraph par62 = new Paragraph(fechasalida, font8N);
        par62.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda62 = new PdfPCell(par62);
        celda62.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda62.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda62.setFixedHeight(15);
        table.addCell(celda62);

        Paragraph par63 = new Paragraph("FECHA DE LLEGADA", font8);
        par63.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda63 = new PdfPCell(par63);
        celda63.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda63.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda63.setFixedHeight(15);
        celda63.setBackgroundColor(myColor);
        table.addCell(celda63);

        if (resguardoTemporalRepository.findById(id).get().getFechaLlegada() == null) {
            fechallegada = "N/A";
        } else {

            fechallegada2 = resguardoTemporalRepository.findById(id).get().getFechaLlegada();
            Integer dia = fechallegada2.getDayOfMonth();
            String diaformato = String.format("%02d", dia);
            Integer mes= fechallegada2.getMonthValue();
            String mesformato = String.format("%02d", mes);
            Integer year= fechallegada2.getYear();
            fechallegada=diaformato  +"/"+mesformato+"/"+String.valueOf(year);

            //fechallegada = resguardoTemporalRepository.findById(id).get().getFechaLlegada().toString();
        }
        Paragraph par64 = new Paragraph(fechallegada, font8N);
        par64.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda64 = new PdfPCell(par64);
        celda64.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda64.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda64.setFixedHeight(15);
        table.addCell(celda64);


        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() == 1) {
            Paragraph par59b2 = new Paragraph("KM DE SALIDA", font8);
            par59b2.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda59b2 = new PdfPCell(par59b2);
            celda59b2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            celda59b2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda59b2.setFixedHeight(15);
            celda59b2.setBackgroundColor(myColor);
            table.addCell(celda59b2);

            if (resguardoTemporalRepository.findById(id).get().getKmSalida() == null) {
                kmSalida = "N/A";
            } else {
                kmSalida = resguardoTemporalRepository.findById(id).get().getKmSalida().toString();
            }
            Paragraph par60b2 = new Paragraph(kmSalida, font8N);
            par60b2.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda60b2 = new PdfPCell(par60b2);
            celda60b2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            celda60b2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda60b2.setFixedHeight(15);
            table.addCell(celda60b2);
        }

        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() == 1) {
            Paragraph par59b3 = new Paragraph("KM DE LLEGADA", font8);
            par59b3.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda59b3 = new PdfPCell(par59b3);
            celda59b3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            celda59b3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda59b3.setFixedHeight(15);
            celda59b3.setBackgroundColor(myColor);
            table.addCell(celda59b3);

            if (resguardoTemporalRepository.findById(id).get().getKmLlegada() == null) {
                kmLlegada = "N/A";
            } else {
                kmLlegada = resguardoTemporalRepository.findById(id).get().getKmLlegada().toString();
            }
            Paragraph par60b3 = new Paragraph(kmLlegada, font8N);
            par60b3.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda60b3 = new PdfPCell(par60b3);
            celda60b3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            celda60b3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            celda60b3.setFixedHeight(15);
            table.addCell(celda60b3);
        }

        par2.setMultipliedLeading(0.8f);
        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() != 1) {
            par2.setMultipliedLeading(1.4f);
        }
        par2.add(new Phrase("De conformidad con el artículo 93 de la Ley de Adquisiciones, Arrendamientos, Administracion y Enajenación de Bienes Muebles del Estado de Veracruz, los servidores públicos que tengan bienes muebles bajo su custodia, resguardo o uso derivado, serán responsables de su cuidado, y en su caso, de su reposición, del resarcimiento de los daños y perjuicios causados, independientes de las responsabilidades que resulten. Cuando los bienes estén asegurados, pagarán gastos directos e indirectos del rescate del monto asegurado. El usuario es responsable de notificar de inmediato al Departamento de Recursos Materiales y Servicios Generales, robo parcial o total de los vehículos. ", font9N));
        par2.setAlignment(Element.ALIGN_JUSTIFIED);
        par2.add(new Phrase(Chunk.NEWLINE));

        float[] column2 = {1f, 1f};
        PdfPTable tablaf = new PdfPTable(column2);
        tablaf.setWidthPercentage(100);


        Paragraph par5 = new Paragraph("RECEPCIÓN DE VEHICULO", font8);
        par5.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda1s = new PdfPCell(par5);
        celda1s.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda1s.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda1s.setFixedHeight(35);
        tablaf.addCell(celda1s);

        Paragraph par6 = new Paragraph("DEVOLUCIÓN DEL VEHICULO", font8);
        par6.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda2 = new PdfPCell(par6);
        celda2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda2.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda2.setFixedHeight(35);
        tablaf.addCell(celda2);

        Paragraph par7 = new Paragraph("NOMBRE Y FIRMA DEL PERSONAL COMISIONADO", font8);
        par7.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda3 = new PdfPCell(par7);
        celda3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda3.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        //celda3.setFixedHeight(35);
        celda3.setColspan(2);
        tablaf.addCell(celda3);

        String vacio = "";
        Paragraph vaciopar = new Paragraph(vacio, font8);
        PdfPCell celdavacia = new PdfPCell(vaciopar);
        celdavacia.setBorder(0);
        celdavacia.setColspan(2);
        celdavacia.setFixedHeight(10);


        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() == 1) {
            tablaf.addCell(celdavacia);
            Paragraph par8 = new Paragraph("ENTREGA DEL VEHICULO", font8);
            par7.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda41 = new PdfPCell(par8);
            celda41.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda41.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
            celda41.setFixedHeight(35);
            tablaf.addCell(celda41);

            Paragraph par9 = new Paragraph("RECEPCION DEL VEHICULO", font8);
            par6.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda5 = new PdfPCell(par9);
            celda5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda5.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
            celda5.setFixedHeight(35);
            tablaf.addCell(celda5);

            Paragraph par10s = new Paragraph("NOMBRE Y FIRMA DEL ENCARGADO DEL PARQUE VEHICULAR", font8);
            par10s.setAlignment(Element.ALIGN_CENTER);
            PdfPCell celda6 = new PdfPCell(par10s);
            celda6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda6.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
            //celda3.setFixedHeight(35);
            celda6.setColspan(2);
            tablaf.addCell(celda6);
        }

        tablaf.addCell(celdavacia);

        Paragraph par11s = new Paragraph("OBSERVACIONES AL SALIR:", font8);
        par11s.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda7 = new PdfPCell(par11s);
        celda7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda7.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        //celda7.setFixedHeight(35);
        tablaf.addCell(celda7);

        Paragraph par12 = new Paragraph("OBSERVACIONES AL LLEGAR:", font8);
        par12.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda8 = new PdfPCell(par12);
        celda8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda8.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        //celda8.setFixedHeight(35);
        tablaf.addCell(celda8);


        String observacionessalida;
        String observacionesllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getObservacionesSalida()==null){
            observacionessalida = "N/A";
        }else{
            observacionessalida = resguardoTemporalRepository.getReferenceById(id).getObservacionesSalida().toString();
        }

        if(resguardoTemporalRepository.getReferenceById(id).getObservacionesLlegada()==null){
            observacionesllegada = "N/A";
        }else{
            observacionesllegada = resguardoTemporalRepository.getReferenceById(id).getObservacionesLlegada().toString();
        }



        Paragraph par13 = new Paragraph(observacionessalida, font8N);
        par13.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda9 = new PdfPCell(par13);
        celda9.setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        celda9.setVerticalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        celda9.setFixedHeight(35);
        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() != 1) {
            celda9.setFixedHeight(80);
        }

        tablaf.addCell(celda9);

        Paragraph par14 = new Paragraph(observacionesllegada, font8N);
        par14.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda10 = new PdfPCell(par14);
        celda10.setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        celda10.setVerticalAlignment(PdfPCell.ALIGN_JUSTIFIED);
        celda10.setFixedHeight(35);
        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() != 1) {
            celda10.setFixedHeight(80);
        }
        tablaf.addCell(celda10);
        //abrir documento para escribir todas las partes y cerrar documento


        //inicia la tabla de en medio
        float[] column3 = {0.4f, 1};
        PdfPTable tablam = new PdfPTable(column3);
        tablam.setWidthPercentage(100);

        Paragraph par15 = new Paragraph("EXTERIOR", font8);
        par15.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda11 = new PdfPCell(par15);
        celda11.setBorder(0);
        tablam.addCell(celda11);

        Paragraph par16 = new Paragraph("INTERIOR", font8);
        par16.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda12 = new PdfPCell(par16);
        celda12.setBorder(0);
        tablam.addCell(celda12);


        float[] column4 = {1, 1, 1, 1};
        PdfPTable tablam2 = new PdfPTable(column4);
        tablam2.setWidthPercentage(100);

        Paragraph par17 = new Paragraph("SALIDA   LLEGADA", font6);
        par17.setAlignment(Element.ALIGN_LEFT);
        PdfPCell celda13 = new PdfPCell(par17);
        celda13.setBorder(0);
        tablam2.addCell(celda13);

        Paragraph par172 = new Paragraph("SALIDA   LLEGADA", font6);
        par17.setAlignment(Element.ALIGN_LEFT);
        PdfPCell celda132 = new PdfPCell(par172);
        celda132.setBorder(0);
        tablam2.addCell(celda132);

        Paragraph par173 = new Paragraph("              SALIDA                        LLEGADA", font6);
        par173.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda133 = new PdfPCell(par173);
        celda133.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda133.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda133.setBorder(0);
        tablam2.addCell(celda133);

        Paragraph par174 = new Paragraph("   ", font6);
        par174.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda134 = new PdfPCell(par174);
        celda134.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda134.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda134.setBorder(0);
        tablam2.addCell(celda134);


        float[] column5 = {0.7f, 1};
        PdfPTable inner = new PdfPTable(column5);

        String antenasradiosalida;
        String antenasradiollegada;

        if(resguardoTemporalRepository.getReferenceById(id).getAntenaRadioS()==null || resguardoTemporalRepository.getReferenceById(id).getAntenaRadioS()==false){
            antenasradiosalida = String.valueOf(unchecked);
        }else{
            antenasradiosalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getAntenaRadioL()==null || resguardoTemporalRepository.getReferenceById(id).getAntenaRadioL()==false){
            antenasradiollegada = String.valueOf(unchecked);
        }else{
            antenasradiollegada = String.valueOf(checked);
        }

        Paragraph par18 = new Paragraph(antenasradiosalida + " " + antenasradiollegada, font);
        Paragraph par19 = new Paragraph("ANTENAS DE RADIO", font6);
        PdfPCell celda14 = new PdfPCell(par18);
        PdfPCell celda15 = new PdfPCell(par19);
        celda14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda14.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda15.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda14.setBorder(0);
        celda15.setBorder(0);
        inner.addCell(celda14);
        inner.addCell(celda15);


        String plumassalida;
        String plumasllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getPlumasParabrisasS()==null || resguardoTemporalRepository.getReferenceById(id).getPlumasParabrisasS()==false){
            plumassalida = String.valueOf(unchecked);
        }else{
            plumassalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getPlumasParabrisasL()==null || resguardoTemporalRepository.getReferenceById(id).getPlumasParabrisasL()==false){
            plumasllegada = String.valueOf(unchecked);
        }else{
            plumasllegada = String.valueOf(checked);
        }


        Paragraph par20 = new Paragraph(plumassalida + " " + plumasllegada, font);
        Paragraph par21 = new Paragraph("PLUMAS PARABRISAS", font6);
        PdfPCell celda16 = new PdfPCell(par20);
        PdfPCell celda17 = new PdfPCell(par21);
        celda16.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda16.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda17.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda16.setBorder(0);
        celda17.setBorder(0);
        inner.addCell(celda16);
        inner.addCell(celda17);



        String llantarsalida;
        String llantarllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getLlantaRefaccionS()==null || resguardoTemporalRepository.getReferenceById(id).getLlantaRefaccionS()==false){
            llantarsalida = String.valueOf(unchecked);
        }else{
            llantarsalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getLlantaRefaccionL()==null || resguardoTemporalRepository.getReferenceById(id).getLlantaRefaccionL()==false){
            llantarllegada = String.valueOf(unchecked);
        }else{
            llantarllegada = String.valueOf(checked);
        }


        Paragraph par22 = new Paragraph(llantarsalida + " " + llantarllegada, font);
        Paragraph par23 = new Paragraph("LLANTA DE REFACCIÓN", font6);
        PdfPCell celda18 = new PdfPCell(par22);
        PdfPCell celda19 = new PdfPCell(par23);
        celda18.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda18.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda19.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda19.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda18.setBorder(0);
        celda19.setBorder(0);
        inner.addCell(celda18);
        inner.addCell(celda19);


        String tgasolinasalida;
        String tgasolinallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getTaponGasolinaS()==null || resguardoTemporalRepository.getReferenceById(id).getTaponGasolinaS()==false){
            tgasolinasalida = String.valueOf(unchecked);
        }else{
            tgasolinasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getTaponGasolinaL()==null || resguardoTemporalRepository.getReferenceById(id).getTaponGasolinaL()==false){
            tgasolinallegada = String.valueOf(unchecked);
        }else{
            tgasolinallegada = String.valueOf(checked);
        }

        Paragraph par24 = new Paragraph(tgasolinasalida + " " + tgasolinallegada, font);
        Paragraph par25 = new Paragraph("TAPÓN GASOLINA", font6);
        PdfPCell celda20 = new PdfPCell(par24);
        PdfPCell celda21 = new PdfPCell(par25);
        celda20.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda20.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda21.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda21.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda20.setBorder(0);
        celda21.setBorder(0);
        inner.addCell(celda20);
        inner.addCell(celda21);


        String taceitesalida;
        String taceitellegada;

        if(resguardoTemporalRepository.getReferenceById(id).getTaponAceiteS()==null || resguardoTemporalRepository.getReferenceById(id).getTaponAceiteS()==false){
            taceitesalida = String.valueOf(unchecked);
        }else{
            taceitesalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getTaponAceiteL()==null || resguardoTemporalRepository.getReferenceById(id).getTaponAceiteL()==false){
            taceitellegada = String.valueOf(unchecked);
        }else{
            taceitellegada = String.valueOf(checked);
        }


        Paragraph par26 = new Paragraph(taceitesalida + " " + taceitellegada, font);
        Paragraph par27 = new Paragraph("TAPÓN ACEITE", font6);
        PdfPCell celda22 = new PdfPCell(par26);
        PdfPCell celda23 = new PdfPCell(par27);
        celda22.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda22.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda23.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda23.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda22.setBorder(0);
        celda23.setBorder(0);
        inner.addCell(celda22);
        inner.addCell(celda23);


        String pdelanterallegada;
        String pdelanterasalida;

        if(resguardoTemporalRepository.getReferenceById(id).getPlacaDelanteraS()==null || resguardoTemporalRepository.getReferenceById(id).getPlacaDelanteraS()==false){
            pdelanterasalida = String.valueOf(unchecked);
        }else{
            pdelanterasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getPlacaDelanteraL()==null || resguardoTemporalRepository.getReferenceById(id).getPlacaDelanteraS()==false){
            pdelanterallegada = String.valueOf(unchecked);
        }else{
            pdelanterallegada = String.valueOf(checked);
        }

        Paragraph par28 = new Paragraph(pdelanterasalida + " " + pdelanterallegada, font);
        Paragraph par29 = new Paragraph("PLACA DELANTERA", font6);
        PdfPCell celda24 = new PdfPCell(par28);
        PdfPCell celda25 = new PdfPCell(par29);
        celda24.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda24.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda25.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda25.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda24.setBorder(0);
        celda25.setBorder(0);
        inner.addCell(celda24);
        inner.addCell(celda25);


        String ptraserasalida;
        String ptraserallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getPlacaTraseraS()==null || resguardoTemporalRepository.getReferenceById(id).getPlacaTraseraS()==false){
            ptraserasalida = String.valueOf(unchecked);
        }else{
            ptraserasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getPlacaDelanteraL()==null || resguardoTemporalRepository.getReferenceById(id).getPlacaTraseraL()==false){
            ptraserallegada = String.valueOf(unchecked);
        }else{
            ptraserallegada = String.valueOf(checked);
        }

        Paragraph par30 = new Paragraph(ptraserasalida + " " + ptraserallegada, font);
        Paragraph par31 = new Paragraph("PLACA TRASERA", font6);
        PdfPCell celda26 = new PdfPCell(par30);
        PdfPCell celda27 = new PdfPCell(par31);
        celda26.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda26.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda27.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda27.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda26.setBorder(0);
        celda27.setBorder(0);
        inner.addCell(celda26);
        inner.addCell(celda27);


        String elateralderechcosalida;
        String elateralderechollegada;

        if(resguardoTemporalRepository.getReferenceById(id).getEspejoDerechoS()==null || resguardoTemporalRepository.getReferenceById(id).getEspejoDerechoS()==false){
            elateralderechcosalida = String.valueOf(unchecked);
        }else{
            elateralderechcosalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getEspejoDerechoS()==null || resguardoTemporalRepository.getReferenceById(id).getEspejoDerechoL()==false){
            elateralderechollegada = String.valueOf(unchecked);
        }else{
            elateralderechollegada = String.valueOf(checked);
        }

        Paragraph par32 = new Paragraph(elateralderechcosalida + " " + elateralderechollegada, font);
        Paragraph par33 = new Paragraph("ESPEJO LATERAL DERECHO", font6);
        PdfPCell celda28 = new PdfPCell(par32);
        PdfPCell celda29 = new PdfPCell(par33);
        celda28.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda28.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda29.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda29.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda28.setBorder(0);
        celda29.setBorder(0);
        inner.addCell(celda28);
        inner.addCell(celda29);


        String elateralizquierdosalida;
        String elateralizquierdollegada;

        if(resguardoTemporalRepository.getReferenceById(id).getEspejoIzquierdoS()==null || resguardoTemporalRepository.getReferenceById(id).getEspejoIzquierdoS()==false){
            elateralizquierdosalida = String.valueOf(unchecked);
        }else{
            elateralizquierdosalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getEspejoIzquierdoL()==null || resguardoTemporalRepository.getReferenceById(id).getEspejoIzquierdoL()==false){
            elateralizquierdollegada = String.valueOf(unchecked);
        }else{
            elateralizquierdollegada = String.valueOf(checked);
        }

        Paragraph par34 = new Paragraph(elateralizquierdosalida + " " + elateralizquierdollegada, font);
        Paragraph par35 = new Paragraph("ESPEJO LATERAL IZQUIERDO", font6);
        PdfPCell celda30 = new PdfPCell(par34);
        PdfPCell celda31 = new PdfPCell(par35);
        celda30.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda30.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda31.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda31.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda30.setBorder(0);
        celda31.setBorder(0);
        inner.addCell(celda30);
        inner.addCell(celda31);


        String tllantasalida;
        String tllantallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getTaponesLlantaS()==null || resguardoTemporalRepository.getReferenceById(id).getTaponesLlantaS()==false){
            tllantasalida = String.valueOf(unchecked);
        }else{
            tllantasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getTaponesLlantaL()==null || resguardoTemporalRepository.getReferenceById(id).getTaponesLlantaL()==false){
            tllantallegada = String.valueOf(unchecked);
        }else{
            tllantallegada = String.valueOf(checked);
        }

        Paragraph par36 = new Paragraph(tllantasalida + " " + tllantallegada, font);
        Paragraph par37 = new Paragraph("TAPONES DE LLANTA", font6);
        PdfPCell celda32 = new PdfPCell(par36);
        PdfPCell celda33 = new PdfPCell(par37);
        celda32.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda32.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda33.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda33.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda32.setBorder(0);
        celda33.setBorder(0);
        inner.addCell(celda32);
        inner.addCell(celda33);


        String antenasalida;
        String antenallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getAntenaVHFS()==null || resguardoTemporalRepository.getReferenceById(id).getAntenaVHFS()==false){
            antenasalida = String.valueOf(unchecked);
        }else{
            antenasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getAntenaVHFL()==null || resguardoTemporalRepository.getReferenceById(id).getAntenaVHFL()==false){
            antenallegada = String.valueOf(unchecked);
        }else{
            antenallegada = String.valueOf(checked);
        }

        Paragraph par38 = new Paragraph(antenasalida + " " + antenallegada, font);
        Paragraph par39 = new Paragraph("ANTENA VHF", font6);
        PdfPCell celda34 = new PdfPCell(par38);
        PdfPCell celda35 = new PdfPCell(par39);
        celda34.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda34.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda35.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda35.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda34.setBorder(0);
        celda35.setBorder(0);
        inner.addCell(celda34);
        inner.addCell(celda35);

        tablam2.addCell(inner);


        float[] column6 = {0.7f, 1};
        PdfPTable inner2 = new PdfPTable(column6);


        String herramientasalida;
        String herramientallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getHerramientaS()==null || resguardoTemporalRepository.getReferenceById(id).getHerramientaS()==false){
            herramientasalida = String.valueOf(unchecked);
        }else{
            herramientasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getHerramientaL()==null || resguardoTemporalRepository.getReferenceById(id).getHerramientaL()==false){
            herramientallegada = String.valueOf(unchecked);
        }else{
            herramientallegada = String.valueOf(checked);
        }


        Paragraph par182 = new Paragraph(herramientasalida+ " " + herramientallegada, font);
        Paragraph par192 = new Paragraph("HERRAMIENTA DESARMADOR PINZA", font6);
        PdfPCell celda142 = new PdfPCell(par182);
        PdfPCell celda152 = new PdfPCell(par192);
        celda142.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda152.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda142.setBorder(0);
        celda152.setBorder(0);
        inner2.addCell(celda142);
        inner2.addCell(celda152);


        String señalsalida;
        String señalllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getReflejantesS()==null || resguardoTemporalRepository.getReferenceById(id).getReflejantesS()==false){
            señalsalida = String.valueOf(unchecked);
        }else{
            señalsalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getReflejantesL()==null || resguardoTemporalRepository.getReferenceById(id).getReflejantesL()==false){
            señalllegada = String.valueOf(unchecked);
        }else{
            señalllegada = String.valueOf(checked);
        }

        Paragraph par202 = new Paragraph(señalsalida+ " " + señalllegada, font);
        Paragraph par212 = new Paragraph("SEÑALES REFLEJANTES", font6);
        PdfPCell celda162 = new PdfPCell(par202);
        PdfPCell celda172 = new PdfPCell(par212);
        celda162.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda172.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda162.setBorder(0);
        celda172.setBorder(0);
        inner2.addCell(celda162);
        inner2.addCell(celda172);


        String airesalida;
        String airellegada;

        if(resguardoTemporalRepository.getReferenceById(id).getAireAcondicionadoS()==null || resguardoTemporalRepository.getReferenceById(id).getAireAcondicionadoS()==false){
            airesalida = String.valueOf(unchecked);
        }else{
            airesalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getAireAcondicionadoL()==null || resguardoTemporalRepository.getReferenceById(id).getAireAcondicionadoL()==false){
            airellegada = String.valueOf(unchecked);
        }else{
            airellegada = String.valueOf(checked);
        }

        Paragraph par222 = new Paragraph(airesalida + " " + airellegada, font);
        Paragraph par232 = new Paragraph("AIRE ACONDICIONADO", font6);
        PdfPCell celda182 = new PdfPCell(par222);
        PdfPCell celda192 = new PdfPCell(par232);
        celda182.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda192.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda182.setBorder(0);
        celda192.setBorder(0);
        inner2.addCell(celda182);
        inner2.addCell(celda192);

        String extsalida;
        String extllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getExtintorS()==null || resguardoTemporalRepository.getReferenceById(id).getExtintorS()==false){
            extsalida = String.valueOf(unchecked);
        }else{
            extsalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getExtintorL()==null || resguardoTemporalRepository.getReferenceById(id).getExtintorL()==false){
            extllegada = String.valueOf(unchecked);
        }else{
            extllegada = String.valueOf(checked);
        }

        Paragraph par242 = new Paragraph(extsalida + " " + extllegada, font);
        Paragraph par252 = new Paragraph("EXTINTOR", font6);
        PdfPCell celda202 = new PdfPCell(par242);
        PdfPCell celda212 = new PdfPCell(par252);
        celda202.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda212.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda202.setBorder(0);
        celda212.setBorder(0);
        inner2.addCell(celda202);
        inner2.addCell(celda212);


        String gatosalida;
        String gatollegada;

        if(resguardoTemporalRepository.getReferenceById(id).getGatoS()==null || resguardoTemporalRepository.getReferenceById(id).getGatoS()==false){
            gatosalida = String.valueOf(unchecked);
        }else{
            gatosalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getGatoL()==null || resguardoTemporalRepository.getReferenceById(id).getGatoL()==false){
            gatollegada = String.valueOf(unchecked);
        }else{
            gatollegada = String.valueOf(checked);
        }


        Paragraph par262 = new Paragraph(gatosalida + " " + gatollegada, font);
        Paragraph par272 = new Paragraph("GATO", font6);
        PdfPCell celda222 = new PdfPCell(par262);
        PdfPCell celda232 = new PdfPCell(par272);
        celda222.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda232.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda222.setBorder(0);
        celda232.setBorder(0);
        inner2.addCell(celda222);
        inner2.addCell(celda232);

        String polizasalida;
        String polizallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getPolizaSeguroS()==null || resguardoTemporalRepository.getReferenceById(id).getPolizaSeguroS()==false){
            polizasalida = String.valueOf(unchecked);
        }else{
            polizasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getPolizaSeguroL()==null || resguardoTemporalRepository.getReferenceById(id).getPolizaSeguroL()==false){
            polizallegada = String.valueOf(unchecked);
        }else{
            polizallegada = String.valueOf(checked);
        }


        Paragraph par282 = new Paragraph(polizasalida + " " + polizallegada, font);
        Paragraph par292 = new Paragraph("PÓLIZA DE SEGURO", font6);
        PdfPCell celda242 = new PdfPCell(par282);
        PdfPCell celda252 = new PdfPCell(par292);
        celda242.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda252.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda242.setBorder(0);
        celda252.setBorder(0);
        inner2.addCell(celda242);
        inner2.addCell(celda252);


        String calcomaniasalida;
        String calcomaniallegada;

        if(resguardoTemporalRepository.getReferenceById(id).getCalcomaniaVerificacionS()==null || resguardoTemporalRepository.getReferenceById(id).getCalcomaniaVerificacionS()==false){
            calcomaniasalida = String.valueOf(unchecked);
        }else{
            calcomaniasalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getCalcomaniaVerificacionL()==null || resguardoTemporalRepository.getReferenceById(id).getCalcomaniaVerificacionL()==false){
            calcomaniallegada = String.valueOf(unchecked);
        }else{
            calcomaniallegada = String.valueOf(checked);
        }

        Paragraph par302 = new Paragraph(calcomaniasalida + " " + calcomaniallegada, font);
        Paragraph par312 = new Paragraph("CALCOMANIA DE VERIFICACIÓN", font6);
        PdfPCell celda262 = new PdfPCell(par302);
        PdfPCell celda272 = new PdfPCell(par312);
        celda262.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda272.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda262.setBorder(0);
        celda272.setBorder(0);
        inner2.addCell(celda262);
        inner2.addCell(celda272);

        String llavessalida;
        String llavesllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getJuegoLlavesS()==null || resguardoTemporalRepository.getReferenceById(id).getJuegoLlavesS()==false){
            llavessalida = String.valueOf(unchecked);
        }else{
            llavessalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getJuegoLlavesL()==null || resguardoTemporalRepository.getReferenceById(id).getJuegoLlavesL()==false){
            llavesllegada = String.valueOf(unchecked);
        }else{
            llavesllegada = String.valueOf(checked);
        }

        Paragraph par322 = new Paragraph(llavessalida + " " + llavesllegada, font);
        Paragraph par332 = new Paragraph("JUEGO DE LLAVES", font6);
        PdfPCell celda282 = new PdfPCell(par322);
        PdfPCell celda292 = new PdfPCell(par332);
        celda282.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda292.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda282.setBorder(0);
        celda292.setBorder(0);
        inner2.addCell(celda282);
        inner2.addCell(celda292);

        String tsalida;
        String tllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getTarjetaCirculacionS()==null || resguardoTemporalRepository.getReferenceById(id).getTarjetaCirculacionS()==false){
            tsalida = String.valueOf(unchecked);
        }else{
            tsalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getTarjetaCirculacionL()==null || resguardoTemporalRepository.getReferenceById(id).getTarjetaCirculacionL()==false){
            tllegada = String.valueOf(unchecked);
        }else{
            tllegada = String.valueOf(checked);
        }


        Paragraph par342 = new Paragraph(tsalida + " " + tllegada, font);
        Paragraph par352 = new Paragraph("TARJETA DE CIRCULACION", font6);
        PdfPCell celda302 = new PdfPCell(par342);
        PdfPCell celda312 = new PdfPCell(par352);
        celda302.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda312.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda302.setBorder(0);
        celda312.setBorder(0);
        inner2.addCell(celda302);
        inner2.addCell(celda312);


        String licsalida;
        String licllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getLicenciaManejoS()==null || resguardoTemporalRepository.getReferenceById(id).getLicenciaManejoS()==false){
            licsalida = String.valueOf(unchecked);
        }else{
            licsalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getLicenciaManejoL()==null || resguardoTemporalRepository.getReferenceById(id).getLicenciaManejoL()==false){
            licllegada = String.valueOf(unchecked);
        }else{
            licllegada = String.valueOf(checked);
        }


        Paragraph par362 = new Paragraph(licsalida + " " + licllegada, font);
        Paragraph par372 = new Paragraph("LICENCIA DE MANEJO", font6);
        PdfPCell celda322 = new PdfPCell(par362);
        PdfPCell celda332 = new PdfPCell(par372);
        celda322.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda332.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda322.setBorder(0);
        celda332.setBorder(0);
        inner2.addCell(celda322);
        inner2.addCell(celda332);


        String bsalida;
        String bllegada;

        if(resguardoTemporalRepository.getReferenceById(id).getBolaArrastreS()==null || resguardoTemporalRepository.getReferenceById(id).getBolaArrastreS()==false){
            bsalida = String.valueOf(unchecked);
        }else{
            bsalida = String.valueOf(checked);
        }

        if(resguardoTemporalRepository.getReferenceById(id).getBolaArrastreL()==null || resguardoTemporalRepository.getReferenceById(id).getBolaArrastreL()==false){
            bllegada = String.valueOf(unchecked);
        }else{
            bllegada = String.valueOf(checked);
        }


        Paragraph par402 = new Paragraph(bsalida + " " + bllegada, font);
        Paragraph par412 = new Paragraph("BOLA DE ARRASTRE", font6);
        PdfPCell celda362 = new PdfPCell(par402);
        PdfPCell celda372 = new PdfPCell(par412);
        celda362.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda372.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celda362.setBorder(0);
        celda372.setBorder(0);
        inner2.addCell(celda362);
        inner2.addCell(celda372);


        float[] column7 = {1, 1};

        PdfPTable inner3 = new PdfPTable(column7);


        Paragraph par500 = new Paragraph("NIVELES", font6);
        PdfPCell cell1 = new PdfPCell(par500);
        cell1.setColspan(2);
        tablam2.setWidthPercentage(100);
        cell1.setBackgroundColor(new BaseColor(211, 211, 211));
        cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        inner3.addCell(cell1);

        Paragraph par502 = new Paragraph("LÍQUIDO FRENOS", font6);
        PdfPCell cell12 = new PdfPCell(par502);
        cell12.setColspan(2);
        cell12.setBackgroundColor(new BaseColor(211, 211, 211));
        cell12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell12.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        inner3.addCell(cell12);

        String frenosSalida;
        String frenosLlegada;


        if (resguardoTemporalRepository.findById(id).get().getNivelFrenosS() == null) {
            frenosSalida = "N/A";
        } else {
            frenosSalida = resguardoTemporalRepository.findById(id).get().getNivelFrenosS().toString();
        }

        if (resguardoTemporalRepository.findById(id).get().getNivelFrenosL() == null) {
            frenosLlegada = "N/A";
        } else {
            frenosLlegada = resguardoTemporalRepository.findById(id).get().getNivelFrenosL().toString();
        }
        Paragraph par512 = new Paragraph(frenosSalida, font6);
        Paragraph par5122 = new Paragraph(frenosLlegada, font6);
        PdfPCell celda462 = new PdfPCell(par512);
        PdfPCell celda472 = new PdfPCell(par5122);
        celda462.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda472.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda462.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda472.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda462.setFixedHeight(27);
        celda472.setFixedHeight(27);

        inner3.addCell(celda462);
        inner3.addCell(celda472);


        Paragraph par503 = new Paragraph("ACEITE MOTOR", font6);
        PdfPCell cell13 = new PdfPCell(par503);
        cell13.setColspan(2);
        cell13.setBackgroundColor(new BaseColor(211, 211, 211));
        cell13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell13.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        inner3.addCell(cell13);

        String aceiteSalida;
        String aceiteLlegada;

        if (resguardoTemporalRepository.findById(id).get().getNivelAceiteS() == null) {
            aceiteSalida = "N/A";
        } else {
            aceiteSalida = resguardoTemporalRepository.findById(id).get().getNivelAceiteS().toString();
        }

        if (resguardoTemporalRepository.findById(id).get().getNivelAceiteL() == null) {
            aceiteLlegada = "N/A";
        } else {
            aceiteLlegada = resguardoTemporalRepository.findById(id).get().getNivelAceiteL().toString();
        }
        Paragraph par513 = new Paragraph(aceiteSalida, font6);
        Paragraph par5132 = new Paragraph(aceiteLlegada, font6);
        PdfPCell celda463 = new PdfPCell(par513);
        PdfPCell celda473 = new PdfPCell(par5132);
        celda463.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda473.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda463.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda473.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda463.setFixedHeight(27);
        celda473.setFixedHeight(27);

        inner3.addCell(celda463);
        inner3.addCell(celda473);

        Paragraph par504 = new Paragraph("ANTICONGELANTE", font6);
        PdfPCell cell14 = new PdfPCell(par504);
        cell14.setColspan(2);
        cell14.setBackgroundColor(new BaseColor(211, 211, 211));
        cell14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell14.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        inner3.addCell(cell14);

        String anticongelanteSalida;
        String anticongelanteLlegada;

        if (resguardoTemporalRepository.findById(id).get().getNivelAnticongelanteS() == null) {
            anticongelanteSalida = "N/A";
        } else {
            anticongelanteSalida = resguardoTemporalRepository.findById(id).get().getNivelAnticongelanteS().toString();
        }

        if (resguardoTemporalRepository.findById(id).get().getNivelAnticongelanteL() == null) {
            anticongelanteLlegada = "N/A";
        } else {
            anticongelanteLlegada = resguardoTemporalRepository.findById(id).get().getNivelAnticongelanteL().toString();
        }
        Paragraph par514 = new Paragraph(anticongelanteSalida, font6);
        Paragraph par5142 = new Paragraph(anticongelanteLlegada, font6);
        PdfPCell celda464 = new PdfPCell(par514);
        PdfPCell celda474 = new PdfPCell(par5142);
        celda464.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda474.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda464.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda474.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda464.setFixedHeight(27);
        celda474.setFixedHeight(27);

        inner3.addCell(celda464);
        inner3.addCell(celda474);

        Paragraph par505 = new Paragraph("GASOLINA", font6);
        PdfPCell cell15 = new PdfPCell(par505);
        cell15.setColspan(2);
        cell15.setBackgroundColor(new BaseColor(211, 211, 211));
        cell15.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell15.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        inner3.addCell(cell15);


        String gasolinaSalida;
        String gasolinaLlegada;

        if (resguardoTemporalRepository.findById(id).get().getNivelGasolinaS() == null) {
            gasolinaSalida = "N/A";
        } else {
            gasolinaSalida = resguardoTemporalRepository.findById(id).get().getNivelGasolinaS().toString();
        }

        if (resguardoTemporalRepository.findById(id).get().getNivelGasolinaL() == null) {
            gasolinaLlegada = "N/A";
        } else {
            gasolinaLlegada = resguardoTemporalRepository.findById(id).get().getNivelGasolinaL().toString();
        }
        Paragraph par515 = new Paragraph(gasolinaSalida, font6);
        Paragraph par5152 = new Paragraph(gasolinaLlegada, font6);
        PdfPCell celda465 = new PdfPCell(par515);
        PdfPCell celda475 = new PdfPCell(par5152);
        celda465.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda475.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda465.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda475.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);

        inner3.addCell(celda465);
        inner3.addCell(celda475);


        tablam2.addCell(inner2);
        tablam2.addCell(inner3);

        PdfPCell automovil = new PdfPCell(img);
        automovil.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        automovil.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        tablam2.addCell(automovil);


        document.open();

        document.add(par1);
        document.add(new Phrase(Chunk.NEWLINE));
        document.add(table);

        if (resguardoTemporalRepository.findById(id).get().getVehiculo().getCategoria().getTipoTransporte().getId() == 1) {
            document.add(tablam);
            document.add(tablam2);
        }

        document.add(new Phrase(Chunk.NEWLINE));
        document.add(par2);
        document.add(new Phrase(Chunk.NEWLINE));
        document.add(tablaf);
        document.close();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"resguardoTemporal.pdf\"").body(document);
    }
}
