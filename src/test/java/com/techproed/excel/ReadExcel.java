package com.techproed.excel;

import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {
       // String homepath=System.getProperty("home.user");
        String filePath="C:\\Users\\Ayse\\IdeaProjects\\pom_tekrar\\src\\test\\java\\resources\\baskentler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(filePath);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(0);
        Cell cell= row.getCell(0);
        System.out.println(cell);

    }
    @Test
    public void read(){
        String filePath="C:\\Users\\Ayse\\IdeaProjects\\pom_tekrar\\src\\test\\java\\resources\\baskentler.xlsx";
        ExcelUtil excelUtil=new ExcelUtil(filePath,"Sayfa1");
        System.out.println(excelUtil.getCellData(1,2));
        System.out.println(excelUtil.columnCount());
        System.out.println(excelUtil.getColumnsNames());
        //System.out.print(excelUtil.getDataList());
        excelUtil.setCellData("Climate",0,6);

    }

}
