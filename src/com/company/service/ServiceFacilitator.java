package com.company.service;

import com.company.Configuration;
import com.company.entity.TransactionEntity;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ServiceFacilitator extends Thread {
    private HashMap<String, List<TransactionEntity>> dataPool;
    private String serviceClassName;
    private Object serviceInstance;

    public ServiceFacilitator(String serviceClassName, HashMap<String, List<TransactionEntity>> dataPool) {
        this.serviceClassName = serviceClassName;
        this.dataPool = dataPool;
    }

    public void run() {
        try {
            Class serviceClass = Class.forName("com.company.service." + serviceClassName);

            if (Arrays.asList(Configuration.standAloneServices).contains(serviceClassName)) {
                serviceInstance = serviceClass.newInstance();
            } else if (Arrays.asList(Configuration.aggregateServices).contains(serviceClassName)) {
                serviceInstance = serviceClass.getDeclaredConstructors()[0].newInstance(dataPool);
            }

            if (serviceInstance != null) {
                Method calculateMethod = serviceClass.getMethod("calculate");
                System.out.println(serviceClassName + " was trigggered >>");
                List<TransactionEntity> calculationResult = (List<TransactionEntity>) calculateMethod.invoke(serviceInstance);
                System.out.println(serviceClassName + " finished !!");
                dataPool.put(serviceClassName, calculationResult);
            } else {
                System.out.println("Invalid Service: " + serviceClassName);
            }
        } catch (Exception e) {
            // ignore
        }
    }
}
