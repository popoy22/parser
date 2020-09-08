package com.tosca.parser.entity.extension;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Stamp {
    // TimeStamp
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",  updatable = false)
    private Date createdAt;

    @Column(length = 200,name = "created_by")
    private String created_by;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(length = 200, name = "updated_by")
    private String updatedBy;


    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @Column(length = 200, name = "deleted_by")
    private String deletedBy;
}
