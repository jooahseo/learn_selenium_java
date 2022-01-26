import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDrivenExcel {
    public static void main(String[] args) throws IOException {
        DataDrivenExcel dde = new DataDrivenExcel();
        ArrayList<String> data = dde.getTestData("city");
        for(String d : data){
            System.out.println(d);
        }
    }

    public ArrayList<String> getTestData(String testCase) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/jooahseo/Google Drive (seo.jooah@gmail.com)/Coding Bootcamp/Java/testing/learn_selenium_java/src/testData/demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        ArrayList<String> testdata = new ArrayList<>();

        int sheetsCount = workbook.getNumberOfSheets();
        for(int i=0; i<sheetsCount; i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
                /**
                 * Identify test cases column by scanning the entire 1st row
                 * Once column is identified -> scan entire column -> get data of that row
                 */
                XSSFSheet sheet = workbook.getSheetAt(i); //sheet is a collection of rows
                Iterator<Row> rows =  sheet.iterator(); //row is a collection of cells
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
                int col = 0;
                while(cell.hasNext()){
                    Cell value = cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase("TestCase")){
                        //found desired column
                        break;
                    }
                    col++;
                }
                //column is identified -> get data from the desired row
                while(rows.hasNext()){
                    Row row = rows.next();
                    if(row.getCell(col).getStringCellValue().equalsIgnoreCase(testCase)){
                        //desired row identified - pull all the data of that row
                        Iterator<Cell> values = row.cellIterator();
                        values.next(); // skip the first column's data (it's testcase)
                        while(values.hasNext()){
                            Cell c = values.next();
                            if(c.getCellType().equals(CellType.STRING)){
                                testdata.add(c.getStringCellValue());
                            }else{
                                testdata.add(String.valueOf(c.getNumericCellValue()));
                            }

                        }
                    }
                }
            }
        }
        return testdata;
    }
}
