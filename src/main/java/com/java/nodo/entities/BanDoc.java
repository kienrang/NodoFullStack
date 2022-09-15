package com.java.nodo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bandoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "ngaytaotk")
    private Date ngayTao;

    @Column(name = "hang")
    private int hang;

}
