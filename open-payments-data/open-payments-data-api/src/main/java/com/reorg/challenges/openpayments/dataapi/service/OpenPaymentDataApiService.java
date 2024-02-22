package com.reorg.challenges.openpayments.dataapi.service;

import com.reorg.challenges.openpayments.dataapi.entity.GeneralPayments;
import com.reorg.challenges.openpayments.dataapi.repository.OpenPaymentDataApiRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpenPaymentDataApiService {

    private OpenPaymentDataApiRepository repository;

    public Page<GeneralPayments> search(String query) {
        var pageRequest = PageRequest.of(0, 20);
        return repository.fullTextSearch(query, pageRequest);
    }
}
