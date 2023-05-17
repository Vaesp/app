package com.example.app.PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class MembreteFooteriText extends PdfPageEventHelper {
    public void onStartPage(PdfWriter writer, Document document) {
        try
        {
            PdfContentByte cb = writer.getDirectContent();


            Image img = Image.getInstance("src/main/java/com/example/app/PDF/img/footer.jpg");
            img.setAbsolutePosition(0f, 15f);
            img.scaleToFit(620f, 620f);
            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);


            cb.addImage(img);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
