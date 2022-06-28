package com.techproed.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadandWriteExcel02 {

        @Test
        public void readExcel() throws IOException {
        String path = ".\\src\\test\\java\\resources\\baskentler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
//        Cell cell = row.createCell(7);
//        cell.setCellValue("Climate");
        //    System.out.println(cell);
            Cell yeni=sheet.getRow(1).createCell(8);
            yeni.setCellValue("Mahmut");
            System.out.println(yeni);


    }
    @Test
        public void writeExcel() throws IOException {
            String path = "C:\\Users\\Ayse\\IdeaProjects\\pom_tekrar\\src\\test\\java\\resources\\baskentler.xlsx";
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook=WorkbookFactory.create(fileInputStream);
            Sheet sheet=workbook.getSheetAt(0);
            Row row=sheet.getRow(0);
            row.createCell(6).setCellValue("Climate");



    }
}
