package com.tosca.parser.entity;

import com.tosca.parser.entity.extension.Stamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCase extends Stamp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, name = "name")
    private String name;

    @Column(length = 255, name = "result")
    private String result;


}
