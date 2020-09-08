package com.tosca.parser.dto.response.testsuite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestSuiteDTO {
    private Long id;
    private String name;
    private List<TestCaseDTO> testcases;
}
