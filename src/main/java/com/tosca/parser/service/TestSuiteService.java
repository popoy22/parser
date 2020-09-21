package com.tosca.parser.service;

import com.tosca.parser.dto.response.TestDTO;
import com.tosca.parser.dto.response.ToscasTestCaseDTO;
import com.tosca.parser.dto.response.testsuite.TestSuiteDTO;

import java.util.List;

public interface TestSuiteService {
    List<TestSuiteDTO> index();
    List<ToscasTestCaseDTO> index2();
    List<TestSuiteDTO> archived();
}
