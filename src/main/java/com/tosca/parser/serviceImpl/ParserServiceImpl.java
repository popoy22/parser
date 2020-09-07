package com.tosca.parser.serviceImpl;


import com.tosca.parser.dto.response.TestDTO;
import com.tosca.parser.dto.response.TestResultDTO;
import com.tosca.parser.service.ParserService;
import org.springframework.stereotype.Service;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ParserServiceImpl implements ParserService {

    public List<TestDTO> parse(String url) throws ParserConfigurationException, IOException, SAXException {

        List<TestDTO> testDTOList = new ArrayList<>();


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        factory.setNamespaceAware(true);


        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(url);

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("testsuite");



        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                TestDTO testDTO = new TestDTO();
                testDTO.setName( elem.getAttribute("name"));
                List<TestResultDTO> resultDTOList = new ArrayList<>();

                for(int r = 0; r < elem.getElementsByTagName("testcase").getLength(); r++){

                    TestResultDTO testResultDTO = new TestResultDTO();
                    Node node1 = elem.getElementsByTagName("testcase").item(r);
                    Element elem1 = (Element) node1;

                    testResultDTO.setName(elem1.getAttribute("name"));
                    testResultDTO.setResult(elem1.getChildNodes().item(1).getNodeName());
                    resultDTOList.add(testResultDTO);

                }

                testDTO.setResults(resultDTOList);





                testDTOList.add(testDTO);
            }


        }


        return testDTOList;
    }

}
