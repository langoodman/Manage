package com.ctgu.lan.manage.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@Table(name = "medicine")
public class Medicine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;
    @Column(name = "origin")
    private String origin;
    @Column(name = "specification")
    private String specification;
    @Column(name = "price")
    private Double price;
    @Column(name = "stock")
    private Integer stock;

}