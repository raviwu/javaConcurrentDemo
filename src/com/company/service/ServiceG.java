package com.company.service;

import com.company.Configuration;
import com.company.entity.TransactionEntity;

import java.util.HashMap;
import java.util.List;

public class ServiceG extends AggregateService implements ServiceInterface {
    private String[] fetchList = Configuration.aggregateServiceAssignment.get("ServiceG");

    public ServiceG(HashMap<String, List<TransactionEntity>> dataPool) {
        super(dataPool);
    }

    @Override
    public List<TransactionEntity> calculate() throws InterruptedException {
        return calculate(fetchList);
    }
}
