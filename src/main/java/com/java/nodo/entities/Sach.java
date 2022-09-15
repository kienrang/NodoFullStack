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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sach")
public class Sach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten")
    private String ten;

    @ManyToOne
    @JoinColumn(name = "id_tacgia")
    private TacGia tacGia;

    @ManyToOne
    @JoinColumn(name = "id_nxb")
    private NhaXuatBan nhaXuatBan;

    @Column(name = "chude")
    private String chuDe;

    @Column(name = "namxuatban")
    private Date namXuatBan;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "soluongconlai")
    private int soLuongConLai;

    @Column(name = "soluongdangmuon")
    private int soLuongDangMuon;

    @Column(name = "tongsach")
    private int tongSoLuong;
}
