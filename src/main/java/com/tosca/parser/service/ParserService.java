package com.tosca.parser.service;

import com.tosca.parser.dto.response.TestDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ParserService {
    List<TestDTO> parse(String url) throws ParserConfigurationException, IOException, SAXException;
}
