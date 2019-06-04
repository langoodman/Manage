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
    @Column(name = "staff_name")
    private String staffName;
    @Column(name = "pharmacy_name")
    private String pharmacyName;
    @Column(name = "user_card_id")
    private String userCardId;
    @Column(name = "should_money")
    private Double shouldMoney;
    @Column(name = "really_money")
    private Double reallyMoney;
    @Column(name = "integral")
    private Integer integral;

}