import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class secondexcel {

    public static void main(String[] args) {
        // File paths of the two Excel sheets
        String file1 = "C://Users//ashrafansari//Music//asdc1.xlsx";
        String file2 = "C://Users//ashrafansari//Music//asdf2.xlsx";

        // Try-with-resources to ensure proper closing of resources
        try (FileInputStream fis1 = new FileInputStream(new File(file1));
             FileInputStream fis2 = new FileInputStream(new File(file2))) {

            // Create Workbook instances from the Excel files
            Workbook wb1 = new XSSFWorkbook(fis1);
            Workbook wb2 = new XSSFWorkbook(fis2);

            // Get the first sheet of both workbooks
            Sheet sheet1 = wb1.getSheetAt(0);
            Sheet sheet2 = wb2.getSheetAt(0);

            // Compare the sheets
            compareSheets(sheet1, sheet2);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to compare the contents of two sheets
    private static void compareSheets(Sheet sheet1, Sheet sheet2) {
        int rowCount1 = sheet1.getPhysicalNumberOfRows();
        int rowCount2 = sheet2.getPhysicalNumberOfRows();
        boolean areEqual = true;

        // Compare rows
        for (int i = 0; i < Math.max(rowCount1, rowCount2); i++) {
            Row row1 = sheet1.getRow(i);
            Row row2 = sheet2.getRow(i);

            // If row1 or row2 is null, treat it as an empty row
            if (row1 == null) row1 = sheet1.createRow(i);
            if (row2 == null) row2 = sheet2.createRow(i);

            // Compare columns within each row
            int colCount1 = row1.getPhysicalNumberOfCells();
            int colCount2 = row2.getPhysicalNumberOfCells();

            for (int j = 0; j < Math.max(colCount1, colCount2); j++) {
                Cell cell1 = row1.getCell(j);
                Cell cell2 = row2.getCell(j);

                // If cells are null, treat them as empty cells
                String cellValue1 = (cell1 != null) ? cell1.toString() : "";
                String cellValue2 = (cell2 != null) ? cell2.toString() : "";

                // Compare cell values
                if (!cellValue1.equals(cellValue2)) {
                    System.out.println("Difference found at row " + (i + 1) + ", column " + (j + 1));
                    System.out.println("File1 value: " + cellValue1);
                    System.out.println("File2 value: " + cellValue2);
                    areEqual = false;
                }
            }
        }

        // Print if the sheets are identical
        if (areEqual) {
            System.out.println("The two sheets are identical.");
        } else {
            System.out.println("There are differences between the two sheets.");
        }
    }
}
