package com.java.nodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nodo.dao.SachDAO;
import com.java.nodo.entities.Sach;
import com.java.nodo.service.SachRepository;

@Service
public class SachDaoIplm implements SachDAO {

    @Autowired
    private SachRepository sachRepository;

    @Override
    public List<Sach> getAll() {
        return this.sachRepository.findAll();
    }

    @Override
    public Sach getOne(Integer id) {
        return this.sachRepository.getReferenceById(id);
    }

    @Override
    public Sach insert(Sach s) {
        return this.sachRepository.save(s);
    }

    @Override
    public Sach update(Sach s) {
        return this.sachRepository.save(s);
    }

    @Override
    public int delete(Integer id) {
        if (id == null) {
            return 0;
        }
        this.sachRepository.delete(this.getOne(id));
        return 1;
    }

    @Override
    public List<Sach> getByName() {
        return null;
    }

}
