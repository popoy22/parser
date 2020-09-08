package com.tosca.parser.dto.response.testsuite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseDTO {
    private Long id;
    private String name;
    private String result;
}
