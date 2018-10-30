package com.task.atm.service;

import com.task.atm.model.OperationInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {
    void saveOperation(OperationInfo operationInfo);
    List<OperationInfo> getAllOperations();
}
