package com.example.app.PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class MembreteHeaderiTextSolicitud extends  PdfPageEventHelper {
    public void onStartPage(PdfWriter writer, Document document) {
        try
        {
            PdfContentByte cb = writer.getDirectContent();


            Image img1 = Image.getInstance("src/main/java/com/example/app/PDF/img/veracruz.png");
            img1.setAbsolutePosition(30f, 550f);
            img1.scaleToFit(70f, 70f);

            Image img2 = Image.getInstance("src/main/java/com/example/app/PDF/img/pc.png");
            img2.setAbsolutePosition(120f, 550f);
            img2.scaleToFit(70f, 70f);

            Image img3 = Image.getInstance("src/main/java/com/example/app/PDF/img/vera.png");
            img3.setAbsolutePosition(210f, 555f);
            img3.scaleToFit(40f, 40f);



            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);




            cb.addImage(img1);
            cb.addImage(img2);
            cb.addImage(img3);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("DEPARTAMENTO DE RECURSOS MATERIALES Y SERVICIOS GENERALES", fontitulo), 750,565,0);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("PARQUE VEHICULAR", fontitulo), 750,550,0);
            LocalDate fecha;
            fecha=LocalDate.now();
            Integer dia=fecha.getDayOfMonth();
            String mes= fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toString();
            Integer año= fecha.getYear();
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("Xalapa, Ver. a "+dia.toString()+" de " + mes +" de " +año.toString(), fontitulo), 750,535,0);

            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("SOLICITUD DE COMBUSTIBLE", fontitulo), 35,535,0);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}