package com.java.nodo.dao;

import java.util.List;

import com.java.nodo.entities.MuonSach;

public interface MuonSachDAO {

    public MuonSach insert(MuonSach ms);

    public MuonSach update(MuonSach ms);

    public int delete(Integer id);

    public List<MuonSach> getAll();

    public MuonSach getOne(Integer id);

}
