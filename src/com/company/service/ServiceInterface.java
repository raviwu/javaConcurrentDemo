package com.company.service;

import com.company.entity.TransactionEntity;

import java.util.List;

public interface ServiceInterface {
    List<TransactionEntity> calculate() throws InterruptedException;
}
