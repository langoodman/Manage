package com.ctgu.lan.manage.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString
@Entity
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "pass_word")
    private String passWord;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;
    @Column(name = "last_time")
    private String lastTime;
    @Column(name = "sign_time")
    private Date signTime;
}