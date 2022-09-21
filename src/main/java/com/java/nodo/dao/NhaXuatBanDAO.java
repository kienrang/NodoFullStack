package com.java.nodo.dao;

import java.util.List;

import com.java.nodo.entities.NhaXuatBan;

public interface NhaXuatBanDAO {
    public List<NhaXuatBan> getAll();

    public NhaXuatBan insert(NhaXuatBan nxb);

    public NhaXuatBan update(NhaXuatBan nxb);

    public NhaXuatBan getOne(Integer nxb);

    public int delete(Integer id);

}
