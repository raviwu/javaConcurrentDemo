package com.company.entity;

public class TransactionEntityFactory {
    private TransactionEntityFactory() {}

    public static TransactionEntity create(TransactionEntity entity) {
        return new TransactionEntity(
                entity.getClientLayout(),
                entity.getBillingCode(),
                entity.getBatchNumber());
    }
}
