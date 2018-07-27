package com.company;

import com.company.entity.TransactionEntity;
import com.company.service.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private static HashMap<String, List<TransactionEntity>> dataPool = new HashMap<String, List<TransactionEntity>>();

    public static void main(String[] args) throws InterruptedException {
        Date startTime = new Date();
        System.out.println("==== Started Process DEMO at " + startTime);
        proceedServices();

        while(!isAllAggregateServicesComplete()) {
            TimeUnit.MILLISECONDS.sleep(1);
        }

        Date endTime = new Date();
        System.out.println("==== Finished Process DEMO at " + endTime);
        System.out.println(">>>> Time spend: " + (endTime.getTime() - startTime.getTime()) / 1000 + " seconds");
    }

    private static void proceedServices() {
        String[] services = Configuration.allServices;
        for(String serviceClassName : services) {
            ServiceFacilitator facilitator = new ServiceFacilitator(serviceClassName, dataPool);
            facilitator.start();
        }
    }

    private static boolean isAllAggregateServicesComplete() {
        HashMap<String, Boolean> servicesStatus = new HashMap<String, Boolean>();

        boolean isCompleted = false;

        while(!isCompleted) {
            for(String serviceName : Configuration.aggregateServices) {
                if (dataPool.containsKey(serviceName)) {
                    servicesStatus.put(serviceName, true);
                }
            }
            isCompleted = servicesStatus.values().size() == Configuration.aggregateServices.length;
        }

        return isCompleted;
    }
}
