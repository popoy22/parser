package com.tosca.parser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="TOSCATESTSUITE")
public class ToscaTestSuite {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  long toscatestsuite_id;

    @Column(length = 255, name = "test_scenario_id")
    private long test_scenario_id;

    @Column(length = 255, name = "test_case_id")
    private long test_case_id;

    @Column(length = 255, name = "enviroment_id")
    private long enviroment_id;

    @Column(length = 255, name = "scenario_id")
    private String scenario_id;

    @Column(length = 255, name ="case_id")
    private String case_id;

    @Column(length = 255, name ="env_id")
    private String env_id;

    @Column(length = 255, name ="tc_type")
    private String tc_type;

    @Column(length = 255, name ="app_id")
    private String app_id;

    @Column(length = 255, name ="country")
    private String country;

    @Column(length = 255, name ="status")
    private String status;

    @Column(length = 255, name ="exec_date")
    private String exec_date;

    @Column(length = 255, name ="exec_time")
    private String exec_time;

    @Column(length = 255, name ="remarks")
    private String remarks;

    @Column(length = 255, name ="receivedon")
    private Timestamp receivedon;

    @Column(length = 255, name ="createdon")
    private Timestamp createdon;

    @Column(length = 255, name ="createdby")
    private String createdby;

    @Column(length = 255, name ="updatedon")
    private Timestamp updatedon;

    @Column(length = 255, name ="updatedby")
    private String updatedby;





}
