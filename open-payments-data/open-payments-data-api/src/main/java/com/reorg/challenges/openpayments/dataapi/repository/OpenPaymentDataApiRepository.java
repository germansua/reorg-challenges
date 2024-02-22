package com.reorg.challenges.openpayments.dataapi.repository;

import com.reorg.challenges.openpayments.dataapi.entity.GeneralPayments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OpenPaymentDataApiRepository extends JpaRepository<GeneralPayments, String> {

    @Query(value = "SELECT * FROM general_payments WHERE MATCH(covered_recipient_profile_id, change_type, date_of_payment) AGAINST (?1 IN BOOLEAN MODE)",
            countQuery = "SELECT COUNT(*) FROM general_payments WHERE MATCH(covered_recipient_profile_id, change_type, date_of_payment) AGAINST (?1 IN BOOLEAN MODE)",
            nativeQuery = true)
    Page<GeneralPayments> fullTextSearch(String query, Pageable pageable);
}
