package read.read;

import read.model.Country;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelFileToList {
    public static List<Country> readExcelData(String fileName) throws IOException {
        List<Country> countriesList = new ArrayList<>();

        //Create the input stream from the xlsx/xls file
        try (FileInputStream fis = new FileInputStream(fileName)) {

            Workbook workbook = new XSSFWorkbook(fis);
            //Create Workbook instance for xlsx/xls file input stream
            ;

            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();

            //loop through each of the sheets
            for (int i = 0; i < numberOfSheets; i++) {

                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);

                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    String name = "";
                    String shortCode = "";

                    //Get the row object
                    Row row = rowIterator.next();

                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext()) {
                        //Get the Cell object
                        Cell cell = cellIterator.next();

                        //check the cell type and process accordingly
                        switch (cell.getCellType()) {
                            case STRING:
                                if (shortCode.equalsIgnoreCase("")) {
                                    shortCode = cell.getStringCellValue().trim();
                                } else if (name.equalsIgnoreCase("")) {
                                    //2nd column
                                    name = cell.getStringCellValue().trim();
                                } else {
                                    //random data, leave it
                                    System.out.println("Random data::" + cell.getStringCellValue());
                                }
                                break;
                            case NUMERIC:
                                System.out.println("Random data::" + cell.getNumericCellValue());
                        }
                    } //end of cell iterator
                    if (!(name.equals("") && shortCode.equals(""))) {
                        Country c = new Country(name, shortCode);
                        countriesList.add(c);
                    }

                } //end of rows iterator

            } //end of sheets for loop
        }
        return countriesList;
    }
}
