package com.mycompany.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class ExcelUtil {
    private Workbook workbook;

    public ExcelUtil(String filePath) throws Exception {
        try (FileInputStream fis = new FileInputStream(filePath)) { workbook = new XSSFWorkbook(fis); }
    }

    public List<Map<String, String>> getData(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        List<Map<String, String>> data = new ArrayList<>();
        Iterator<Row> rows = sheet.iterator();
        Row headerRow = rows.next();
        List<String> headers = new ArrayList<>();
        headerRow.forEach(cell -> headers.add(cell.getStringCellValue()));
        while (rows.hasNext()) {
            Row row = rows.next();
            Map<String, String> rowData = new HashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                rowData.put(headers.get(i), cell.getStringCellValue());
            }
            data.add(rowData);
        }
        return data;
    }
}
