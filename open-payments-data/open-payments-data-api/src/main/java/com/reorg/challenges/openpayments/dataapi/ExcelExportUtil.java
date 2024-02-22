package com.reorg.challenges.openpayments.dataapi;

import com.reorg.challenges.openpayments.dataapi.entity.GeneralPayments;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class ExcelExportUtil {

    public static byte[] exportToExcel(List<GeneralPayments> generalPaymentsList) throws IOException {
        try (var workbook = new XSSFWorkbook()) {
            var sheet = workbook.createSheet("Report");
            var headerRow = sheet.createRow(0);
            var fields = GeneralPayments.class.getDeclaredFields();
            var headers = Arrays.stream(fields).map(Field::getName).toList();

            for (int col = 0; col < headers.size(); col++) {
                var cell = headerRow.createCell(col);
                cell.setCellValue(headers.get(col));
            }

            int rowNum = 1;
            for (var generalPayments : generalPaymentsList) {
                var row = sheet.createRow(rowNum++);
                var gets = Arrays.stream(GeneralPayments.class.getDeclaredMethods())
                        .filter(method -> method.getName().startsWith("get"))
                        .toList();

                for (int i = 0; i < gets.size(); i++) {
                    try {
                        row.createCell(i).setCellValue( gets.get(0).invoke(generalPayments).toString());
                    } catch (IllegalAccessException | InvocationTargetException ex) {
                        System.out.println("Something went wrong when invoking get method: " + ex);
                    }
                }
            }

            var outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
