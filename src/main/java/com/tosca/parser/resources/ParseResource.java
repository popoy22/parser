package com.tosca.parser.resources;


import com.tosca.parser.dto.response.TestDTO;
import com.tosca.parser.service.ParserService;
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

    @GetMapping(value = "/parse", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<TestDTO>> index(@RequestParam String url ) throws ParserConfigurationException, IOException, SAXException {
        return new ResponseEntity<List<TestDTO>>(parserService.parse(url), HttpStatus.OK);
    }


}
