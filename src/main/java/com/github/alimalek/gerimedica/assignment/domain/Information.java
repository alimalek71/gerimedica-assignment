package com.github.alimalek.gerimedica.assignment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Information {
    @Id
    private String code;
    @Column(length = 10)
    private String source;
    @Column(length = 10)
    private String codeListCode;
    @Column(length = 60)
    private String displayValue;
    @Column(columnDefinition = "CHARACTER VARYING", length = 1000)
    private String longDescription;
    private Date fromDate;
    private Date toDate;
    private Integer sortingPriority;
}
