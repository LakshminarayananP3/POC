package com.lnt.txttopdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class ConvertorMain {

//    Issues
//  1. Handle the page height
//  2. handle the asa carriage controls
//  3. handle record format (stream/direct/normal)

    public static void main(String[] args) throws Exception {
        for (int i=0; i<200;i++)
            System.out.println(i);
        ConvertorMain conv = new ConvertorMain();
        conv.start();
    }

//    String inputFile = "/Users/admin/OneDrive - Platform 3 Solutions LLC/projects/cmod/data/dev/approach2/spoolfile.txt";
    String inputFile = "/Users/admin/OneDrive - Platform 3 Solutions LLC/projects/tmb/docs/manual/hats-loan-api-app/inputs/0000000003";

    private void start() throws Exception {
        byte[] bytes = Files.readAllBytes(new File(inputFile).toPath());
        String newPage = "31da";
        String hexValue = "";
        String content = "";
        String zeros = "00";
        String hexString = "";
        int maxLineLength = 79;// 79 default value by diving default A4 width 595/7.6
        int previousIndexOfLineBreak = 0;
        int pageCounter = 0;
        int lineCount = 0;
        for (int i = 0; i < bytes.length; i++) {
            if(pageCounter >= 1)
                break;
            if (i > 2) {
                hexValue = Integer.toHexString(bytes[i - 2]) + Integer.toHexString(bytes[i - 1]) + Integer.toHexString(bytes[i]);
                if (hexValue.equals(newPage)) {
                    pageCounter++;
                }
            }
            if (Integer.toHexString(bytes[i]).equals("a")) {
                if ((i - previousIndexOfLineBreak) > maxLineLength)
                    maxLineLength = (i - previousIndexOfLineBreak);
                previousIndexOfLineBreak = i;
                lineCount++;
            }
        }

        Font font = new Font(BaseFont.createFont("/Users/admin/Downloads/font/3.courmon1.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.setMargins(50, 50, 50, 50);
        int maxWidth = 0;
//        maxWidth = (int) (maxLineLength * 7.6);
        maxWidth = 1400;
        int maxHeight = 1400;
        Rectangle two = new Rectangle(maxWidth + 50, maxHeight);
        document.setPageSize(two);
        document.open();

        for (int i = 0; i < bytes.length; i++) {
            hexString = zeros + Integer.toHexString(bytes[i]);
            hexString = hexString.substring(hexString.length() - 2);
            content += hexString;
            if (i > 2) {
                hexValue = Integer.toHexString(bytes[i - 2]) + Integer.toHexString(bytes[i - 1]) + Integer.toHexString(bytes[i]);
                if (hexValue.equals(newPage)) {
                    byte[] newBytes = javax.xml.bind.DatatypeConverter.parseHexBinary(content.substring(0, content.length() - 6));
                    document.add(new Paragraph(new String(newBytes), font));
                    content = content.substring(content.length() - 6);
                    document.newPage();
                }
            }
        }
        byte[] newBytes = javax.xml.bind.DatatypeConverter.parseHexBinary(content);
        content = new String(newBytes);
        document.add(new Paragraph(content, font));
        document.close();

        System.out.println("Awesome PDF just got created.");
    }
}






















