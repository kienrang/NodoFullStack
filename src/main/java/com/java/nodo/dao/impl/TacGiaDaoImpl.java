package com.java.nodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nodo.dao.TacGiaDAO;
import com.java.nodo.entities.TacGia;
import com.java.nodo.service.TacGiaRepository;

@Service
public class TacGiaDaoImpl implements TacGiaDAO {

    @Autowired
    private TacGiaRepository tacGiaRepository;

    @Override
    public List<TacGia> getAll() {
        return this.tacGiaRepository.findAll();
    }

    @Override
    public TacGia getOne(Integer id) {
        return this.tacGiaRepository.getReferenceById(id);
    }

    @Override
    public TacGia insert(TacGia tg) {
        return this.tacGiaRepository.save(tg);
    }

    @Override
    public TacGia update(TacGia tg) {
        return this.tacGiaRepository.save(tg);
    }

    @Override
    public int delete(Integer id) {
        this.tacGiaRepository.delete(this.getOne(id));
        return 1;
    }

}
