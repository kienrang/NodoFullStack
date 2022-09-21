package com.java.nodo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.nodo.dao.NhaXuatBanDAO;
import com.java.nodo.entities.NhaXuatBan;
import com.java.nodo.service.NhaXuatBanRepository;

@Service
public class NXBDaoImpl implements NhaXuatBanDAO {

    @Autowired
    private NhaXuatBanRepository banRepository;

    @Override
    public List<NhaXuatBan> getAll() {
        try {
            return this.banRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public NhaXuatBan insert(NhaXuatBan nxb) {
        return this.banRepository.save(nxb);
    }

    @Override
    public NhaXuatBan update(NhaXuatBan nxb) {
        return this.banRepository.save(nxb);
    }

    @Override
    public NhaXuatBan getOne(Integer id) {
        return this.banRepository.getReferenceById(id);
    }

    @Override
    public int delete(Integer id) {
        this.banRepository.delete(this.banRepository.getOne(id));
        return 1;
    }

}
