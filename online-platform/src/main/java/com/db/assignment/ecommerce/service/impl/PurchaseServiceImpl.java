package com.db.assignment.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.assignment.ecommerce.model.PurchaseInfo;
import com.db.assignment.ecommerce.repository.PurchaseInfoRepository;
import com.db.assignment.ecommerce.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	PurchaseInfoRepository purchaseRepo;

	@Override
	public PurchaseInfo savePurchaseReq(PurchaseInfo purchase) {
		return purchaseRepo.save(purchase);
	}

}
