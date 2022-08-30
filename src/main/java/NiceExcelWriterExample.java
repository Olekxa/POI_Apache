import model.Book;
import write.TableWriter;

import java.io.IOException;
import java.util.List;

public class NiceExcelWriterExample {
    public static void main(String[] args) throws IOException {
        org.apache.log4j.BasicConfigurator.configure();

        TableWriter excelTableWriter = new TableWriter();

        List<Book> listBook = excelTableWriter.getListBook();
        String excelFilePath = "NiceJavaBooks.xls";

        excelTableWriter.writeExcel(listBook, excelFilePath);

    }
}
