package com.company.service;

import com.company.MockData;
import com.company.entity.TransactionEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceC extends StandaloneService {
    @Override
    public List<TransactionEntity> calculate() throws InterruptedException {
        MockData.randomDelay();
        return new ArrayList<TransactionEntity>(MockData.getData().subList(MockData.batchSize * 1, MockData.batchSize * 3));
    }
}
