package com.company.service;

import com.company.entity.TransactionEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AggregateService extends StandaloneService {
    protected HashMap<String, List<TransactionEntity>> dataPool;

    public AggregateService(HashMap<String, List<TransactionEntity>> dataPool) {
        this.dataPool = dataPool;
    }

    public List<TransactionEntity> calculate(String[] fetchList) throws InterruptedException {
        List<TransactionEntity> result = null;

        for (int i = 0; i < fetchList.length; i++) {
            waitForService(fetchList[i]);

            if (i == 0) {
                result = dataPool.get(fetchList[i]);
            } else {
                List<TransactionEntity> calculatedResultFromService = (List<TransactionEntity>) ((ArrayList<TransactionEntity>) dataPool.get(fetchList[i])).clone();

                for (TransactionEntity entity : calculatedResultFromService) {
                    if (result.contains(entity)) {
                        TransactionEntity existedEntity = result.get(result.indexOf(entity));
                        existedEntity.setCount(existedEntity.getCount() + entity.getCount());
                    } else {
                        result.add(entity);
                    }
                }
            }
        }

        return result;
    }

    private void waitForService(String serviceName) throws InterruptedException {
        while (!dataPool.containsKey(serviceName)) {
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }
}
