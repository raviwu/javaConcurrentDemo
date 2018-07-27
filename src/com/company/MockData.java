package com.company;

import com.company.entity.TransactionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MockData {
    public static int mockSize = 10000;
    public static int batchSize = mockSize / 5;
    private static List<TransactionEntity> mockDataPool = new ArrayList<TransactionEntity>();

    static {
        for(int i = 0; i < mockSize; i++) {
            mockDataPool.add(new TransactionEntity("ClientLayout" + i, "BillingCode" + i, "BatchNumber" + i));
        }
    }

    private MockData() {}

    public static List<TransactionEntity> getData() {
        return mockDataPool;
    }
    public static void randomDelay() throws InterruptedException {
        int delaySecond = (int) (Math.random() * 5) + 1;
        TimeUnit.SECONDS.sleep(delaySecond);
        System.out.println("Finished random Delay: " + delaySecond + " seconds");
    }
}
