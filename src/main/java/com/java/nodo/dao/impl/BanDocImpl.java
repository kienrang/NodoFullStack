package com.java.nodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nodo.dao.BanDocDAO;
import com.java.nodo.entities.BanDoc;
import com.java.nodo.service.BanDocRepository;

@Service
public class BanDocImpl implements BanDocDAO {

    @Autowired
    private BanDocRepository banDocRepository;

    @Override
    public BanDoc insert(BanDoc b) {
        return this.banDocRepository.save(b);
    }

    @Override
    public BanDoc update(BanDoc b) {
        return this.banDocRepository.save(b);
    }

    @Override
    public BanDoc getOne(Integer id) {
        return this.banDocRepository.getReferenceById(id);
    }

    @Override
    public int delete(Integer id) {
        try {
            this.banDocRepository.delete(this.getOne(id));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<BanDoc> getAll() {
        return this.banDocRepository.findAll();
    }

    @Override
    public List<BanDoc> getByName(String name) {
        // return this.banDocRepository.getByName(name);
        return null;
    }

}
