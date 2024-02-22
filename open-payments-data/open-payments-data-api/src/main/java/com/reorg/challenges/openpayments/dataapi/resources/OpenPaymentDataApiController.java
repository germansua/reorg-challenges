package com.reorg.challenges.openpayments.dataapi.resources;

import com.reorg.challenges.openpayments.dataapi.ExcelExportUtil;
import com.reorg.challenges.openpayments.dataapi.entity.GeneralPayments;
import com.reorg.challenges.openpayments.dataapi.service.OpenPaymentDataApiService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/open-payments/api")
@AllArgsConstructor
public class OpenPaymentDataApiController {

    private OpenPaymentDataApiService service;

    @GetMapping("/search")
    public Page<GeneralPayments> search(@RequestParam("query") String query) {
        return service.search(query);
    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> exportToExcel(@RequestParam("query") String query) {
        var searchResults = service.search(query).getContent();
        try {
            var excelBytes = ExcelExportUtil.exportToExcel(searchResults);
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "report.xlsx");
            return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
        } catch (IOException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
