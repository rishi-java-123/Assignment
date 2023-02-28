package com.db.assignment.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.assignment.ecommerce.model.PurchaseInfo;

public interface PurchaseInfoRepository extends JpaRepository<PurchaseInfo, Long> {

}
