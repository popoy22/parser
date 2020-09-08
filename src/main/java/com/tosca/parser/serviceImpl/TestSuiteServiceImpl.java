package com.tosca.parser.serviceImpl;

import com.tosca.parser.dto.response.testsuite.TestSuiteDTO;
import com.tosca.parser.entity.TestSuite;
import com.tosca.parser.repository.TestSuiteRepository;
import com.tosca.parser.service.TestSuiteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class TestSuiteServiceImpl implements TestSuiteService {


    @Autowired
    TestSuiteRepository testSuiteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<TestSuiteDTO> index() {
        List<TestSuite> testSuites = testSuiteRepository.findByDeletedAtNullOrderById();
        return Arrays.asList(modelMapper.map(testSuites, TestSuiteDTO[].class));
    }

    @Transactional(readOnly = true)
    public TestSuiteDTO show(Long id){
        TestSuite testSuite = testSuiteRepository.getOne(id);
        return modelMapper.map(testSuite,TestSuiteDTO.class);
    }


    @Transactional(readOnly = true)
    public List<TestSuiteDTO> archived() {
        List<TestSuite> testSuites = testSuiteRepository.findByDeletedAtNotNullOrderById();
        return Arrays.asList(modelMapper.map(testSuites, TestSuiteDTO[].class));
    }


}
