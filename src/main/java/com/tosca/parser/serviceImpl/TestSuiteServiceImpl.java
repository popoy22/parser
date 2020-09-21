package com.tosca.parser.serviceImpl;

import com.tosca.parser.dto.response.TestDTO;
import com.tosca.parser.dto.response.ToscasTestCaseDTO;
import com.tosca.parser.dto.response.testsuite.TestSuiteDTO;
import com.tosca.parser.entity.TestSuite;
import com.tosca.parser.entity.ToscaTestSuite;
import com.tosca.parser.repository.TestSuiteRepository;
import com.tosca.parser.repository.ToscaTestSuiteRepository;
import com.tosca.parser.service.TestSuiteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TestSuiteServiceImpl implements TestSuiteService {


    @Autowired
    TestSuiteRepository testSuiteRepository;
    
    @Autowired
    ToscaTestSuiteRepository toscaTestSuiteRepository;

    @Autowired
    ModelMapper modelMapper;

   @Transactional(readOnly = true)
    public List<TestSuiteDTO> index() {
        List<TestSuite> testSuites = testSuiteRepository.findByDeletedAtNullOrderById();
        return Arrays.asList(modelMapper.map(testSuites, TestSuiteDTO[].class));
    }





    public List<ToscasTestCaseDTO> index2(){

        List<ToscaTestSuite> toscaTestSuites = toscaTestSuiteRepository.findAll();

        Map<Long,String> mapForResults = new HashMap<Long, String>();
        List<Map<Long , String>> arrResults  = new ArrayList<Map<Long,String>>();

        for (ToscaTestSuite toscaTestSuite : toscaTestSuites) {

            mapForResults.put(toscaTestSuite.getToscatestsuite_id(),"");
            arrResults.add(mapForResults);
            //objMap.put(toscaTestSuite./(),toscaTestSuite);



        }
        return Arrays.asList(modelMapper.map(toscaTestSuites, ToscasTestCaseDTO[].class));

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
