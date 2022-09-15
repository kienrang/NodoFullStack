package com.java.nodo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "muonsach")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuonSach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_bd")
    private BanDoc banDoc;

    @ManyToOne
    @JoinColumn(name = "id_sach")
    private Sach sach;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "ngaymuon")
    private Date ngayMuon;

    @Column(name = "ngaytra")
    private Date ngayTra;

    @Column(name = "trangthai")
    private int trangThai;

    @Column(name = "ghichu")
    private String ghiChu;
}
