package com.task.atm.service;

import com.task.atm.model.OperationInfo;
import com.task.atm.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("mysql-operation-service")
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public void saveOperation(OperationInfo operationInfo) {
        operationRepository.save(operationInfo);
    }

    @Override
    public List<OperationInfo> getAllOperations() {
        return operationRepository.findAll();
    }
}
