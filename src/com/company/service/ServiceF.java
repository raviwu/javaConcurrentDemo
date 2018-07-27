package com.company.service;

import com.company.Configuration;
import com.company.entity.TransactionEntity;

import java.util.HashMap;
import java.util.List;

public class ServiceF extends AggregateService implements ServiceInterface {
    public String[] fetchList = Configuration.aggregateServiceAssignment.get("ServiceF");

    public ServiceF(HashMap<String, List<TransactionEntity>> dataPool) {
        super(dataPool);
    }

    @Override
    public List<TransactionEntity> calculate() throws InterruptedException {
        return calculate(fetchList);
    }
}
