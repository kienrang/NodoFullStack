package com.java.nodo.dao;

import java.util.List;

import com.java.nodo.entities.TacGia;

public interface TacGiaDAO {
    public List<TacGia> getAll();

    public TacGia getOne(Integer id);

    public TacGia insert(TacGia tg);

    public TacGia update(TacGia tg);

    public int delete(Integer id);
}
