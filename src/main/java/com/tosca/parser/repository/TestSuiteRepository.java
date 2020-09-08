package com.tosca.parser.repository;

import com.tosca.parser.entity.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {
    List<TestSuite> findByDeletedAtNotNullOrderById();
    List<TestSuite> findByDeletedAtNullOrderById();
}
