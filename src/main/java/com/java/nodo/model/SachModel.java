package com.java.nodo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SachModel {

    private String ten;

    private int tacGia;

    private int nhaXuatBan;

    private String chuDe;

    private Date namXuatBan;

    private String moTa;

    private int soLuongConLai;

    private int soLuongDangMuon;

    private int tongSoLuong;
}
