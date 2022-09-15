package com.java.nodo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nhaxuatban")
public class NhaXuatBan {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "trang_thai")
    private int trangThai;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "mo_ta")
    private String moTa;

    @JsonIgnore
    @OneToMany(mappedBy = "nhaXuatBan", fetch = FetchType.LAZY)
    private List<Sach> ListSach;

}
