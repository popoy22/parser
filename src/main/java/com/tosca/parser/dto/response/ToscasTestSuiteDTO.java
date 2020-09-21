package com.tosca.parser.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToscasTestSuiteDTO {
    private Long id;
    private Long case_id;
}
