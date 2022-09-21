package com.java.nodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nodo.dao.MuonSachDAO;
import com.java.nodo.entities.MuonSach;
import com.java.nodo.service.MuonSachRepository;

@Service
public class MuonSachDaoImpl implements MuonSachDAO {

    @Autowired
    public MuonSachRepository muonSachRepository;

    @Override
    public MuonSach insert(MuonSach ms) {
        return this.muonSachRepository.save(ms);
    }

    @Override
    public MuonSach update(MuonSach ms) {
        return this.muonSachRepository.save(ms);
    }

    @Override
    public int delete(Integer id) {
        try {
            this.muonSachRepository.delete(this.getOne(id));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<MuonSach> getAll() {
        return this.muonSachRepository.findAll();
    }

    @Override
    public MuonSach getOne(Integer id) {
        return this.muonSachRepository.getReferenceById(id);
    }

}
