package com.example.app.PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MembreteHeaderiTextResguardo extends  PdfPageEventHelper {
    public void onStartPage(PdfWriter writer, Document document) {
        try
        {
            PdfContentByte cb = writer.getDirectContent();


            Image img1 = Image.getInstance("src/main/java/com/example/app/PDF/img/veracruz.png");
            img1.setAbsolutePosition(30f, 700f);
            img1.scaleToFit(100f, 100f);

            Image img2 = Image.getInstance("src/main/java/com/example/app/PDF/img/pc.png");
            img2.setAbsolutePosition(160f, 700f);
            img2.scaleToFit(100f, 100f);

            Image img3 = Image.getInstance("src/main/java/com/example/app/PDF/img/vera.png");
            img3.setAbsolutePosition(300f, 700f);
            img3.scaleToFit(70f, 70f);



            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);

            cb.addImage(img1);
            cb.addImage(img2);
            cb.addImage(img3);
           // ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("RESGUARDO TEMPORAL", fontitulo), 580,750,0);

            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("DEPARTAMENTO DE RECURSOS MATERIALES Y SERVICIOS GENERALES", fontitulo), 580,750,0);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("PARQUE VEHICULAR", fontitulo), 580,735,0);
            LocalDate fecha;
            fecha=LocalDate.now();
            Integer dia=fecha.getDayOfMonth();
            String mes= fecha.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toString();
            Integer año= fecha.getYear();
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("Xalapa, Ver. a "+dia.toString()+" de " + mes +" de " +año.toString(), fontitulo), 580,695,0);

            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("RESGUARDO TEMPORAL", fontitulo), 35,680,0);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}