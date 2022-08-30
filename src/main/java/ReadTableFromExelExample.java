import model.Country;

import java.util.List;

import static read.ReadExcelFileToList.readExcelData;

public class ReadTableFromExelExample {
    public static void main(String args[]){
        List<Country> list = readExcelData("ReadExample.xlsx");
        System.out.println("Country List\n"+list);
    }
}
