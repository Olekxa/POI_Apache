package nice.write;

import nice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class TableWriter {

    public void writeExcel(List<Book> listBook, String excelFilePath) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (Book aBook : listBook) {
            sheet.autoSizeColumn(rowCount);
            Row row = sheet.createRow(++rowCount);
            writeBook(aBook, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    private void writeBook(Book aBook, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(aBook.getTitle());

        cell = row.createCell(2);
        cell.setCellValue(aBook.getAuthor());

        cell = row.createCell(3);
        cell.setCellValue(aBook.getPrice());
    }

    public List<Book> getListBook() {
        Book book1 = new Book("Head First Java", "Kathy Serria", 79);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 36);
        Book book3 = new Book("Clean Code", "Robert Martin", 42);
        Book book4 = new Book("Thinking in Java", "Bruce Eckel", 35);

        List<Book> listBook = Arrays.asList(book1, book2, book3, book4);

        return listBook;
    }
}
