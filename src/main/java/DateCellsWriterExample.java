import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class DateCellsWriterExample {
    public static void main(String[] args) throws IOException {
        org.apache.log4j.BasicConfigurator.configure();

        Workbook wb = new HSSFWorkbook();

        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());


// we style the second cell as a date (and time).  It is important to
// create a new cell style from the workbook otherwise you can end up
// modifying the built in style and effecting not only this cell but other cells.
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        Row newRow = sheet.createRow(1);
        cell = newRow.createCell(0);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);

        try (OutputStream fileOut = new FileOutputStream("workBookWithData.xls")) {
            wb.write(fileOut);
        }
    }
}
