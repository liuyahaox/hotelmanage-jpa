package com.example.jpa.Record;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordid")
    private Integer Recordid;
    @Column(name = "roomid")
    private Integer Roomid;
    @Column(name = "custormerid")
    private Integer Customerid;
    @Column(name = "stime")
    private String stime;
    @Column(name = "etime")
    private String etime;

    
}
