package com.company.service;

import com.company.MockData;
import com.company.entity.TransactionEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceD extends StandaloneService {
    @Override
    public List<TransactionEntity> calculate() throws InterruptedException {
        MockData.randomDelay();
        return new ArrayList<TransactionEntity>(MockData.getData().subList(MockData.batchSize * 2, MockData.batchSize * 4));
    }
}
