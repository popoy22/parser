package com.tosca.parser.entity;

import com.tosca.parser.entity.extension.Stamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestSuite extends Stamp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, name = "name")
    private String name;



    @OneToMany(targetEntity = TestCase.class, cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "testsuite_id", referencedColumnName = "id")
    private List<TestCase> testCases = new ArrayList<>();


}
