package com.java.nodo.dao;

import java.util.List;

import com.java.nodo.entities.BanDoc;

public interface BanDocDAO {
    public BanDoc insert(BanDoc b);

    public BanDoc update(BanDoc b);

    public BanDoc getOne(Integer id);

    public int delete(Integer id);

    public List<BanDoc> getAll();

    public List<BanDoc> getByName(String name);

}
