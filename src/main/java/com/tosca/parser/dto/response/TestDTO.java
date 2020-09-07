package com.tosca.parser.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDTO {
    private String name;
    private List<TestResultDTO> results;
}
