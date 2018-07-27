package com.company.entity;

import java.util.Objects;

public class TransactionEntity {
    private String clientLayout;
    private String billingCode;
    private String batchNumber;
    private long count;

    public TransactionEntity(String clientLayout, String billingCode, String batchNumber) {
        this.clientLayout = clientLayout;
        this.billingCode = billingCode;
        this.batchNumber = batchNumber;
        this.count = (long)(Math.random() * 100000000 + 1);
    }

    public String getClientLayout() {
        return clientLayout;
    }

    public void setClientLayout(String clientLayout) {
        this.clientLayout = clientLayout;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(getClientLayout(), that.getClientLayout()) &&
                Objects.equals(getBillingCode(), that.getBillingCode()) &&
                Objects.equals(getBatchNumber(), that.getBatchNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientLayout(), getBillingCode(), getBatchNumber());
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "clientLayout='" + clientLayout + '\'' +
                ", billingCode='" + billingCode + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", count=" + count +
                '}';
    }
}
