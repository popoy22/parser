package com.tosca.parser.repository;

import com.tosca.parser.entity.TestSuite;
import com.tosca.parser.entity.ToscaTestSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToscaTestSuiteRepository extends JpaRepository<ToscaTestSuite, Long> {

}
