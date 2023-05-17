package com.example.app.PDF;

import com.example.app.Repositories.Tramites.SolicitudCombustibleRepository;
import com.example.app.Repositories.VehiculoRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET}, maxAge = 3600)

@RestController
@RequestMapping(path = "/api/auth/pdfSolicitudCombustible")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class PDFSolicitudCombustible {

    @Autowired
    SolicitudCombustibleRepository solicitudCombustibleRepository;

    @Autowired
    VehiculoRepository vehiculoRepository;

    @GetMapping
    public ResponseEntity downloadPdf(HttpServletResponse response,
                                      Long id) throws Exception {

        Document document = new Document(PageSize.LETTER.rotate());
        document.setMargins(16, 16, 100, 70);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
        MembreteHeaderiTextSolicitud header = new MembreteHeaderiTextSolicitud();

        writer.setPageEvent(header);

        String verdanapath = "src/main/java/com/example/app/PDF/files/verdana.ttf";
        BaseFont verdana = BaseFont.createFont(verdanapath, "Cp1252", true);
        String verdanaBpath = "src/main/java/com/example/app/PDF/files/verdanab.ttf";
        BaseFont verdanaB = BaseFont.createFont(verdanaBpath, "Cp1252", true);

        Paragraph par1 = new Paragraph();
        Paragraph par2 = new Paragraph();
        Paragraph par3 = new Paragraph();
        Paragraph par4 = new Paragraph();
        Font fontitulo = new Font(verdanaB, 9, Font.NORMAL, BaseColor.BLACK);
        Font fontfecha = new Font();
        fontfecha.setSize(8);

        Font font11N = new Font(verdana, 11, Font.NORMAL, BaseColor.BLACK);

        Font font11 = new Font(verdanaB, 11, Font.NORMAL, BaseColor.BLACK);

        Font font10N = new Font(verdana, 10, Font.NORMAL, BaseColor.BLACK);

        Font font10 = new Font(verdanaB, 10, Font.NORMAL, BaseColor.BLACK);

        Font font9 = new Font(verdanaB, 9, Font.NORMAL, BaseColor.BLACK);

        Font font9N = new Font(verdana, 8, Font.NORMAL, BaseColor.BLACK);

        Font font8 = new Font(verdanaB, 8, Font.NORMAL, BaseColor.BLACK);

        Font font8N = new Font(verdana, 8, Font.NORMAL, BaseColor.BLACK);

        Font font7 = new Font(verdanaB, 7, Font.NORMAL, BaseColor.BLACK);

        Font font7N = new Font(verdana, 7, Font.NORMAL, BaseColor.BLACK);

        Font font6 = new Font(verdana, 5, Font.BOLD, BaseColor.BLACK);

        Font font6N = new Font(verdanaB, 6, Font.NORMAL, BaseColor.BLACK);

        Font font5N = new Font(verdanaB, 5, Font.NORMAL, BaseColor.BLACK);

        BaseColor myColor = WebColors.getRGBColor("#E0E0E0");

        PdfPTable tablainicial = new PdfPTable(1);
        tablainicial.setWidthPercentage(105);

        Phrase resumen = new Phrase();
        PdfPCell celli = new PdfPCell();


        celli = new PdfPCell(resumen);
        celli.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celli.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);


        par1.setMultipliedLeading(0.8f);
        // par1.add(new Phrase("Secretaría de Proteción Civil" +"\n" + "Unidad Administrativa" +"\n" + "Departamento de Recursos Materiales y Servicios Generales" +"\n" + "Plantilla Vehicular del año",font7N));
        par1.setAlignment(Element.ALIGN_CENTER);
        par1.add(new Phrase(Chunk.NEWLINE));


        float[] column = {2f, 1f, 1f};
        PdfPTable table = new PdfPTable(column);
        table.setWidthPercentage(95);

        Paragraph par5 = new Paragraph("ÁREA SOLICITANTE", font11);
        par5.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda1 = new PdfPCell(par5);
        celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda1.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda1.setFixedHeight(30);
        celda1.setBackgroundColor(myColor);
        table.addCell(celda1);

        Paragraph par6 = new Paragraph("FECHA", font11);
        par5.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda2 = new PdfPCell(par6);
        celda2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda2.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda2.setFixedHeight(30);
        celda2.setBackgroundColor(myColor);
        table.addCell(celda2);

        Paragraph par7 = new Paragraph("FOLIO", font11);
        par7.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda3 = new PdfPCell(par7);
        celda3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda3.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda3.setFixedHeight(30);
        celda3.setBackgroundColor(myColor);
        table.addCell(celda3);

        String area;
        String fecha;
        LocalDate fecha2;
        String foliodata;

        if (solicitudCombustibleRepository.findById(id).get().getArea().getNombreArea() == null || solicitudCombustibleRepository.findById(id).get().getArea() == null) {
            area = "N/A";
        } else {
            area = solicitudCombustibleRepository.findById(id).get().getArea().getNombreArea();
        }
        Paragraph par8 = new Paragraph(area, font11N);
        par8.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda4 = new PdfPCell(par8);
        celda4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda4.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda4.setFixedHeight(30);
        table.addCell(celda4);


        if (solicitudCombustibleRepository.findById(id).get().getFecha() == null) {
            fecha = "N/A";
        } else {
            fecha2 = solicitudCombustibleRepository.findById(id).get().getFecha();
            Integer dia = fecha2.getDayOfMonth();
            String diaformato = String.format("%02d", dia);
            Integer mes= fecha2.getMonthValue();
            String mesformato = String.format("%02d", mes);
            Integer year= fecha2.getYear();
            fecha=diaformato  +"/"+mesformato+"/"+String.valueOf(year);
        }
        Paragraph par9 = new Paragraph(fecha, font11N);
        par8.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda5 = new PdfPCell(par9);
        celda5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda5.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda5.setFixedHeight(30);
        table.addCell(celda5);

        if (solicitudCombustibleRepository.findById(id).get().getFolio() == null) {
            foliodata = "N/A";
        } else {
            foliodata = solicitudCombustibleRepository.findById(id).get().getFolio();
        }
        Paragraph par10 = new Paragraph(foliodata, font11N);
        par8.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda6 = new PdfPCell(par10);
        celda6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda6.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda6.setFixedHeight(30);
        table.addCell(celda6);


        PdfPTable table2 = new PdfPTable(1);
        table2.setWidthPercentage(95);
        Paragraph par11 = new Paragraph("DATOS DEL VEHÍCULO", font11);
        par7.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda7 = new PdfPCell(par11);
        celda7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda7.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda7.setFixedHeight(30);
        celda7.setBackgroundColor(myColor);
        table2.addCell(celda7);

        float[] column2 = {1f, 1f, 1f, 1f, 1f, 1f};
        PdfPTable table3 = new PdfPTable(column2);
        table3.setWidthPercentage(95);
        Paragraph par12 = new Paragraph("MARCA", font11);
        par12.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda8 = new PdfPCell(par12);
        celda8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda8.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda8.setFixedHeight(30);
        celda8.setBackgroundColor(myColor);
        table3.addCell(celda8);

        Paragraph par13 = new Paragraph("MODELO", font11);
        par13.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda9 = new PdfPCell(par13);
        celda9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda9.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda9.setFixedHeight(30);
        celda9.setBackgroundColor(myColor);
        table3.addCell(celda9);

        Paragraph par14 = new Paragraph("PLACA", font11);
        par14.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda10 = new PdfPCell(par14);
        celda10.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda10.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda10.setFixedHeight(30);
        celda10.setBackgroundColor(myColor);
        table3.addCell(celda10);

        Paragraph par15 = new Paragraph("NUM. ECONÓMICO", font11);
        par15.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda11 = new PdfPCell(par15);
        celda11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda11.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda11.setFixedHeight(30);
        celda11.setBackgroundColor(myColor);
        table3.addCell(celda11);

        Paragraph par16 = new Paragraph("AÑO", font11);
        par16.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda12 = new PdfPCell(par16);
        celda12.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda12.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda12.setFixedHeight(30);
        celda12.setBackgroundColor(myColor);
        table3.addCell(celda12);

        Paragraph par17 = new Paragraph("KILOMETRAJE INICIAL", font11);
        par17.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda13 = new PdfPCell(par17);
        celda13.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda13.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda13.setFixedHeight(30);
        celda13.setBackgroundColor(myColor);
        table3.addCell(celda13);


//Datos reales

        String marca;
        String tipoVehiculo;
        String placa;
        String noEconomico;
        String modelo;
        String kmInicial;

        if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getMarca() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            marca = "N/A";
        } else {
            marca = solicitudCombustibleRepository.findById(id).get().getVehiculo().getMarca().toString();
        }
        Paragraph par18 = new Paragraph(marca, font11N);
        par18.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda14 = new PdfPCell(par18);
        celda14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda14.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda14.setFixedHeight(30);
        table3.addCell(celda14);

        if ( solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            tipoVehiculo = "N/A";
        }
        else if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getCategoria().getId()== 7L)
        {
            tipoVehiculo = "Lancha";
        }
        else if(solicitudCombustibleRepository.findById(id).get().getVehiculo().getTipoVehiculo() == null)
        {
            tipoVehiculo="N/A";
        }
        else {
            tipoVehiculo = solicitudCombustibleRepository.findById(id).get().getVehiculo().getTipoVehiculo().toString();
        }
        Paragraph par19 = new Paragraph(tipoVehiculo, font11N);
        par19.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda15 = new PdfPCell(par19);
        celda15.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda15.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda15.setFixedHeight(30);
        table3.addCell(celda15);

        if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getPlacas() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            placa = "N/A";
        } else {
            placa = solicitudCombustibleRepository.findById(id).get().getVehiculo().getPlacas().toString();
        }
        Paragraph par20 = new Paragraph(placa, font11N);
        par20.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda16 = new PdfPCell(par20);
        celda16.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda16.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda16.setFixedHeight(30);
        table3.addCell(celda16);

        if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getNoEconomico() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            noEconomico = "N/A";
        } else {
            noEconomico = solicitudCombustibleRepository.findById(id).get().getVehiculo().getNoEconomico().toString();
        }
        Paragraph par21 = new Paragraph(noEconomico, font11N);
        par21.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda17 = new PdfPCell(par21);
        celda17.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda17.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda17.setFixedHeight(30);
        table3.addCell(celda17);

        if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getModelo() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            modelo = "N/A";
        }
        else {
            modelo = solicitudCombustibleRepository.findById(id).get().getVehiculo().getModelo().toString();
        }
        Paragraph par22 = new Paragraph(modelo, font11N);
        par22.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda18 = new PdfPCell(par22);
        celda18.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda18.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda18.setFixedHeight(30);
        table3.addCell(celda18);

        if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getKilometraje() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            kmInicial = "N/A";
        } else {
            kmInicial = solicitudCombustibleRepository.findById(id).get().getVehiculo().getKilometraje().toString() + " km";
        }
        Paragraph par23 = new Paragraph(kmInicial, font11N);
        par23.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda19 = new PdfPCell(par23);
        celda19.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda19.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda19.setFixedHeight(30);
        table3.addCell(celda19);


        float[] column3 = {1f, 1f, 1f, 1f, 1f};
        PdfPTable table4 = new PdfPTable(column3);
        table4.setWidthPercentage(95);
        Paragraph par24 = new Paragraph("KILOMETROS A RECORRER (APROX.)", font11);
        par24.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda20 = new PdfPCell(par24);
        celda20.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda20.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda20.setFixedHeight(30);
        celda20.setBackgroundColor(myColor);
        table4.addCell(celda20);

        Paragraph par25 = new Paragraph("KILOMETRAJE FINAL (APROX)", font11);
        par25.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda21 = new PdfPCell(par25);
        celda21.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda21.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda21.setFixedHeight(30);
        celda21.setBackgroundColor(myColor);
        table4.addCell(celda21);

        Paragraph par26 = new Paragraph("CAPACIDAD DE CARGA", font11);
        par26.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda22 = new PdfPCell(par26);
        celda22.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda22.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda22.setFixedHeight(30);
        celda22.setBackgroundColor(myColor);
        table4.addCell(celda22);

        Paragraph par27 = new Paragraph("NIVEL ACTUAL", font11);
        par27.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda23 = new PdfPCell(par27);
        celda23.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda23.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda23.setFixedHeight(30);
        celda23.setBackgroundColor(myColor);
        table4.addCell(celda23);

        Paragraph par28 = new Paragraph("MONTO AUTORIZADO", font11);
        par28.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda24 = new PdfPCell(par28);
        celda24.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda24.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda24.setFixedHeight(30);
        celda24.setBackgroundColor(myColor);
        table4.addCell(celda24);


        String kmRecorrer;
        String kmFinal;
        String capacidad;
        String nivel;
        String monto;

        if (solicitudCombustibleRepository.findById(id).get().getKmPorRecorrer() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            kmRecorrer = "N/A";
        } else {
            kmRecorrer = solicitudCombustibleRepository.findById(id).get().getKmPorRecorrer().toString() + " km";
        }
        Paragraph par29 = new Paragraph(kmRecorrer, font11N);
        par29.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda25 = new PdfPCell(par29);
        celda25.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda25.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda25.setFixedHeight(30);
        table4.addCell(celda25);


        if (solicitudCombustibleRepository.findById(id).get().getKmInicial() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            kmFinal = "N/A";
        } else {
            kmFinal = solicitudCombustibleRepository.findById(id).get().getKmInicial().toString() + " km";
        }
        Paragraph par30 = new Paragraph(kmFinal, font11N);
        par30.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda26 = new PdfPCell(par30);
        celda26.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda26.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda26.setFixedHeight(30);
        table4.addCell(celda26);

        if (solicitudCombustibleRepository.findById(id).get().getVehiculo().getCapacidadTanque() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            capacidad = "N/A";
        } else {
            capacidad = solicitudCombustibleRepository.findById(id).get().getVehiculo().getCapacidadTanque().toString() + " L";
        }
        Paragraph par31 = new Paragraph(capacidad, font11N);
        par31.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda27 = new PdfPCell(par31);
        celda27.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda27.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda27.setFixedHeight(30);
        table4.addCell(celda27);

        if (solicitudCombustibleRepository.findById(id).get().getNivelActual() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            nivel = "N/A";
        } else {
            nivel = solicitudCombustibleRepository.findById(id).get().getNivelActual().toString() ;
        }
        Paragraph par32 = new Paragraph(nivel, font11N);
        par32.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda28 = new PdfPCell(par32);
        celda28.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda28.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda28.setFixedHeight(30);
        table4.addCell(celda28);

        if (solicitudCombustibleRepository.findById(id).get().getMontoAutorizado() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            monto = "N/A";
        } else {
            monto = String.format("%.2f", solicitudCombustibleRepository.findById(id).get().getMontoAutorizado());
        }
        Paragraph par33 = new Paragraph("$ " + monto, font11N);
        par33.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda29 = new PdfPCell(par33);
        celda29.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda29.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda29.setFixedHeight(30);
        table4.addCell(celda29);


        PdfPTable table5 = new PdfPTable(1);
        table5.setWidthPercentage(95);
        par3.add(new Phrase("MOTIVO, LUGAR (MUNICIPIO Y LOCALIDADES) Y PERIODO DE LA COMISIÓN", font11));
        par3.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda30 = new PdfPCell(par3);
        celda30.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda30.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda30.setFixedHeight(30);
        celda30.setBackgroundColor(myColor);
        table5.addCell(celda30);

        par3.setAlignment(Element.ALIGN_CENTER);
        par3.add(new Phrase(Chunk.NEWLINE));

        String motivo;
        String area2;
        String solicitante2;
        String municipio2;
        String motivo2;
        if(solicitudCombustibleRepository.findById(id).get().getArea().getNombreArea() == null){
        area2="N/A";
        }else{
        area2=solicitudCombustibleRepository.findById(id).get().getArea().getNombreArea();
        }
        if(solicitudCombustibleRepository.findById(id).get().getSolicitante() == null){
            solicitante2="N/A";
        }else{
            solicitante2=solicitudCombustibleRepository.findById(id).get().getSolicitante();
        }
        if(solicitudCombustibleRepository.findById(id).get().getMunicipio().getMunicipio() == null){
            municipio2="N/A";
        }else{
            municipio2=solicitudCombustibleRepository.findById(id).get().getMunicipio().getMunicipio();
        }
        if(solicitudCombustibleRepository.findById(id).get().getMotivo() == null || solicitudCombustibleRepository.findById(id).get().getMotivo().isEmpty()){
            motivo2="";
        }else{
            motivo2=solicitudCombustibleRepository.findById(id).get().getMotivo();
        }



        if (solicitudCombustibleRepository.findById(id).get().getMotivo() == null || solicitudCombustibleRepository.findById(id).get().getMotivo().isEmpty() || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null || solicitudCombustibleRepository.findById(id).get().getArea().getNombreArea() == null) {
            motivo = "Se cacrga unidad para disposición del área "+area2+" que conduce el C. "+solicitante2+" comicionado al municipio de "+municipio2+", Ver.";
        } else {
            motivo = "Se cacrga unidad para disposición del área "+area2+" que conduce el C. "+solicitante2+" comicionado al municipio de "+municipio2+", Ver. "+ "con el motivo de "+motivo2 +".";
                    //solicitudCombustibleRepository.findById(id).get().getMotivo().toString();
        }
        Paragraph par34 = new Paragraph(motivo, font10N);
        par34.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda31 = new PdfPCell(par34);
        celda31.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda31.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda31.setFixedHeight(50);
        table5.addCell(celda31);


        float[] column4 = {1f, 1f, 1f};
        PdfPTable table6 = new PdfPTable(column4);
        table6.setWidthPercentage(95);

        Paragraph par35 = new Paragraph("SOLICITANTE", font11);
        par35.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda32 = new PdfPCell(par35);
        celda32.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda32.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda32.setFixedHeight(30);
        celda32.setBackgroundColor(myColor);
        table6.addCell(celda32);

        Paragraph par36 = new Paragraph("REVISA" + "\n" + " (DEPTO. DE RECURSOS MATERIALES Y SERVICIOS GENERALES)", font8);

        par36.setAlignment(Element.ALIGN_CENTER);

        PdfPCell celda33 = new PdfPCell(par36);
        celda33.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda33.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda33.setFixedHeight(30);
        celda33.setBackgroundColor(myColor);
        table6.addCell(celda33);

        Paragraph par37 = new Paragraph("AUTORIZA" + "\n" + " (UNIDAD ADMINISTRATIVA)", font9);
        par37.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda34 = new PdfPCell(par37);
        celda34.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda34.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda34.setFixedHeight(30);
        celda34.setBackgroundColor(myColor);
        table6.addCell(celda34);

        String solicitante;
        String jefeMateriales;
        String jefe;

        if (solicitudCombustibleRepository.findById(id).get().getSolicitante() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            solicitante = "N/A";
        } else {
            solicitante = solicitudCombustibleRepository.findById(id).get().getSolicitante().toString();
        }
        Paragraph par38 = new Paragraph(solicitante, font11N);
        par38.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda35 = new PdfPCell(par38);
        celda35.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda35.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda35.setFixedHeight(70);
        table6.addCell(celda35);

        if (solicitudCombustibleRepository.findById(id).get().getJefeMateriales() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            jefeMateriales = "N/A";
        } else {
            jefeMateriales = solicitudCombustibleRepository.findById(id).get().getJefeMateriales().toString();
        }
        Paragraph par39 = new Paragraph(jefeMateriales, font11N);
        par39.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda36 = new PdfPCell(par39);
        celda36.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda36.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda36.setFixedHeight(70);
        table6.addCell(celda36);

        if (solicitudCombustibleRepository.findById(id).get().getJefeUnidadAdministrativa() == null || solicitudCombustibleRepository.findById(id).get().getVehiculo() == null) {
            jefe = "N/A";
        } else {
            jefe = solicitudCombustibleRepository.findById(id).get().getJefeUnidadAdministrativa().toString();
        }
        Paragraph par40 = new Paragraph(jefe, font11N);
        par40.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda37 = new PdfPCell(par40);
        celda37.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda37.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        celda37.setFixedHeight(70);
        table6.addCell(celda37);


        PdfPTable table7 = new PdfPTable(1);
        table7.setWidthPercentage(95);
        Paragraph par41 = new Paragraph("NOMBRE Y FIRMA", font11);
        par41.setAlignment(Element.ALIGN_CENTER);
        PdfPCell celda38 = new PdfPCell(par41);
        celda38.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda38.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        celda38.setFixedHeight(30);
        celda38.setBackgroundColor(myColor);
        table7.addCell(celda38);
        //abrir documento para escribir todas las partes y cerrar documento
        document.open();
        document.add(par1);
        document.add(table);
        document.add(table2);
        document.add(table3);
        document.add(table4);
        document.add(table5);
        document.add(table6);
        document.add(table7);
        document.close();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"solicitudCombustible.pdf\"").body(document);
    }

}