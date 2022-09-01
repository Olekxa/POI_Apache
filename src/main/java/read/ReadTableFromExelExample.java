package read;

import read.model.Country;

import java.io.IOException;
import java.util.List;

import static read.read.ReadExcelFileToList.readExcelData;

public class ReadTableFromExelExample {
    public static void main(String args[]) throws IOException {
        org.apache.log4j.BasicConfigurator.configure();

        List<Country> list = readExcelData("ReadExample.xlsx");
        System.out.println("Country List\n"+list);
    }
}
