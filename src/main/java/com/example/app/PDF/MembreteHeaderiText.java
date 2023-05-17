package com.example.app.PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MembreteHeaderiText extends PdfPageEventHelper {
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

            String verdanapath = "src/main/java/com/example/app/PDF/files/verdana.ttf";
            BaseFont verdana = BaseFont.createFont(verdanapath, "Cp1252", true);
            String verdanaBpath = "src/main/java/com/example/app/PDF/files/verdanab.ttf";
            BaseFont verdanaB = BaseFont.createFont(verdanaBpath, "Cp1252", true);


            Font font7 = new Font(verdanaB, 7, Font.NORMAL, BaseColor.BLACK);

            Font font7N = new Font(verdana, 7, Font.NORMAL, BaseColor.BLACK);


            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.BLACK);

            Integer fecha = LocalDate.now().getYear();

            cb.addImage(img1);
            cb.addImage(img2);
            cb.addImage(img3);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Secretaría de Proteción Civil", font7N), 400,580,0);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Unidad Administrativa", font7N), 400,572,0);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Departamento de Recursos Materiales y Servicios Generales", font7N), 400,564,0);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Plantilla Vehicular " + fecha, font7), 400,556,0);

            LocalDate fecha2;
            fecha2=LocalDate.now();
            Integer dia=fecha2.getDayOfMonth();
            String mes= fecha2.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toString();
            Integer año= fecha2.getYear();
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase("Xalapa, Ver. a "+dia.toString()+" de " + mes +" de " +año.toString(), font7N), 745,556,0);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}