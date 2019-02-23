package com.tdd.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public static void main(String[] args) throws IOException {


    }

    public ArrayList<String> getData(String testcaseName) throws IOException {
        ArrayList<String> array = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("/home/mhosp/Desktop/tdd.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();


        for (int i = 0; i < sheets; i++) {

            if (workbook.getSheetName(i).equalsIgnoreCase("TestData"))

            // here 'TestData' is SheetName of Excel file

            {

                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows

                Row firstrow = rows.next();

                Iterator<Cell> ce = firstrow.cellIterator(); // row is collection of cells

                int k = 0;

                int column = 0;

                while (ce.hasNext()) {

                    Cell value = ce.next();

                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {

                        column = k;

                    }

                    k++;

                }

                System.out.println(column);

                while (rows.hasNext())
                {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
                    {

                        //after you grab purchase testcase row = pull all the data of that row feed into test

                        Iterator<Cell> cv = r.cellIterator();
                        while(cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellTypeEnum() == CellType.STRING) {
                                array.add(c.getStringCellValue());
                            }else{
                                array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return array;
    }
}