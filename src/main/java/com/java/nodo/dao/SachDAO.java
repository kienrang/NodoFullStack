package com.java.nodo.dao;

import java.util.List;

import com.java.nodo.entities.Sach;

public interface SachDAO {
    public List<Sach> getAll();

    public Sach getOne(Integer id);

    public Sach insert(Sach s);

    public Sach update(Sach s);

    public int delete(Integer id);

    public List<Sach> getByName();
}
