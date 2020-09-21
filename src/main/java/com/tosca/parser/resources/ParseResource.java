package com.tosca.parser.resources;


import com.tosca.parser.dto.response.TestDTO;
import com.tosca.parser.dto.response.ToscasTestCaseDTO;
import com.tosca.parser.dto.response.testsuite.TestSuiteDTO;
import com.tosca.parser.service.ParserService;
import com.tosca.parser.service.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ParseResource {

    @Autowired
    ParserService parserService;

    @Autowired
    TestSuiteService testSuiteService;

    @GetMapping(value = "/parse", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<TestDTO>> parse(@RequestParam String url ) throws ParserConfigurationException, IOException, SAXException {
        return new ResponseEntity<List<TestDTO>>(parserService.parse(url), HttpStatus.OK);
    }

    @GetMapping(value = "/testsuites", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<TestSuiteDTO>> index(){
        return new ResponseEntity<List<TestSuiteDTO>>(testSuiteService.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/testsuites2", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<ToscasTestCaseDTO>> index2(){
        return new ResponseEntity<List<ToscasTestCaseDTO>>(testSuiteService.index2(), HttpStatus.OK);
    }


    @GetMapping(value = "/testsuites/archived", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<TestSuiteDTO>> archived(){
        return new ResponseEntity<List<TestSuiteDTO>>(testSuiteService.archived(), HttpStatus.OK);
    }



}
