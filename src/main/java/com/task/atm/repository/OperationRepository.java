package com.task.atm.repository;

import com.task.atm.model.OperationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationInfo, Long> {

}
