import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class excelcampare1 {

    public static void main(String[] args) {
        // File paths of the two Excel sheets
        String file1 = "C://Users//ashrafansari//Music//camil report.xlsx";
        String file2 = "C://Users//ashrafansari//Music//SM report.xlsx";

        try {
            // Load the Excel files
            FileInputStream fis1 = new FileInputStream(new File(file1));
            FileInputStream fis2 = new FileInputStream(new File(file2));

            // Create Workbook instances from the Excel files
            Workbook wb1 = new XSSFWorkbook(fis1);
            Workbook wb2 = new XSSFWorkbook(fis2);

            // Get the first sheet of both workbooks
            Sheet sheet1 = wb1.getSheetAt(0);
            Sheet sheet2 = wb2.getSheetAt(0);

            // Compare the sheets
            compareSheets(sheet1, sheet2);

            // Close the file input streams
            fis1.close();
            fis2.close();
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

            // Compare columns within each row
            int colCount1 = row1 != null ? row1.getPhysicalNumberOfCells() : 0;
            int colCount2 = row2 != null ? row2.getPhysicalNumberOfCells() : 0;

            for (int j = 0; j < Math.max(colCount1, colCount2); j++) {
                Cell cell1 = row1 != null ? row1.getCell(j) : null;
                Cell cell2 = row2 != null ? row2.getCell(j) : null;

                String cellValue1 = cell1 != null ? cell1.toString() : "";
                String cellValue2 = cell2 != null ? cell2.toString() : "";

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
