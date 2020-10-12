package model;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Parser {
    public static void parser(String path) throws IOException {
        XSSFWorkbook xwb = new XSSFWorkbook(path);
        XSSFSheet sheet = xwb.getSheetAt(0);
        XSSFRow row;
        Day day;
        for (int i = sheet.getFirstRowNum() + 1; i < 367; i++) {
            day = new Day();
            row = sheet.getRow(i);
            day.setDate(row.getCell(0).getDateCellValue());
            day.setIntitule(row.getCell(1).getStringCellValue());
            if (row.getLastCellNum()>=12){
                day.setDescription(row.getCell(12).getStringCellValue());
                day.setWord1EN(row.getCell(2).getStringCellValue());
                day.setWord1FR(row.getCell(3).getStringCellValue());
                day.setWord2EN(row.getCell(4).getStringCellValue());
                day.setWord2FR(row.getCell(5).getStringCellValue());
                day.setWord3EN(row.getCell(6).getStringCellValue());
                day.setWord3FR(row.getCell(7).getStringCellValue());
                day.setWord4EN(row.getCell(8).getStringCellValue());
                day.setWord4FR(row.getCell(9).getStringCellValue());
                day.setWord5EN(row.getCell(10).getStringCellValue());
                day.setWord5FR(row.getCell(11).getStringCellValue());
            } else {
                day.setDescription("Description not available");
            }
            //System.out.println(day);
        }
        xwb.close();


    }

}
