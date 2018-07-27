package com.company;

import java.util.HashMap;

public class Configuration {
    public static HashMap<String, String[]> aggregateServiceAssignment = new HashMap<String, String[]>();
    public static String[] allServices = {"ServiceA", "ServiceB", "ServiceC", "ServiceD", "ServiceE", "ServiceF", "ServiceG"};
    public static String[] standAloneServices = {"ServiceA", "ServiceB", "ServiceC", "ServiceD", "ServiceE"};
    public static String[] aggregateServices = {"ServiceF", "ServiceG"};
    static {
        String[] serviceFWaitingList = {"ServiceA", "ServiceB"};
        aggregateServiceAssignment.put("ServiceF", serviceFWaitingList);
        String[] serviceGWaitingList = {"ServiceB", "ServiceC", "ServiceD", "ServiceE"};
        aggregateServiceAssignment.put("ServiceG", serviceGWaitingList);
    }
}
