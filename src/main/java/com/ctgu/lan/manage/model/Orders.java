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
@Table(name = "Orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "staff_id")
    private Integer staffId;
    @Column(name = "pharmacy_id")
    private Integer pharmacyId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "should_money")
    private Double shouldMoney;
    @Column(name = "relly_money")
    private Double rellyMoney;
    @Column(name = "integral")
    private Integer integral;

}