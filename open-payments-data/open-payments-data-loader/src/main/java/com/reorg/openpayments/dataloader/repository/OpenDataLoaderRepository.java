package com.reorg.openpayments.dataloader.repository;

import com.reorg.openpayments.dataloader.entity.GeneralPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenDataLoaderRepository extends JpaRepository<GeneralPayments, String> {
}
