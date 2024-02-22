package com.reorg.openpayments.dataloader.service;

import com.opencsv.CSVReader;
import com.reorg.openpayments.dataloader.entity.GeneralPayments;
import com.reorg.openpayments.dataloader.repository.OpenDataLoaderRepository;
import lombok.AllArgsConstructor;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@AllArgsConstructor
public class DataLoaderService {

    private static final int THRESHOLD = 1000;
    private OpenDataLoaderRepository repository;

    public void loadCSV(String path) {
        var generalPaymentsFields = GeneralPayments.class.getDeclaredFields();

        var index = 0L;
        var tmpRowList = new ArrayList<GeneralPayments>();

        try (var reader = new CSVReader(new FileReader(path))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                if (index == 0) {
                    index++;
                    continue;
                }

                var generalPayments = getGeneralPayments(generalPaymentsFields, row);
                tmpRowList.add(generalPayments);

                if (index++ % THRESHOLD == 0) {
                    repository.saveAll(tmpRowList);
                    repository.flush();
                    tmpRowList.clear();
                    System.out.println("*** Persisting 1000 records ...");
                }
            }

            if (!tmpRowList.isEmpty()) {
                repository.saveAll(tmpRowList);
                repository.flush();
            }
        } catch (Exception ex) {
            System.err.println("There was a problem while loading the file: " + ex);
        }
    }

    private GeneralPayments getGeneralPayments(Field[] generalPaymentsFields, String[] row) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        var generalPayments = new GeneralPayments();

        for (int i = 0; i < generalPaymentsFields.length; i++) {
            var fieldName = generalPaymentsFields[i].getName();
            var setterName = "set" + fieldName.substring(0 ,1).toUpperCase() + fieldName.substring(1);
            var setter = GeneralPayments.class.getDeclaredMethod(setterName, String.class);
            setter.setAccessible(true);
            setter.invoke(generalPayments, row[i]);
        }
        return generalPayments;
    }
}
