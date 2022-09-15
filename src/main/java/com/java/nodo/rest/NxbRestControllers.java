package com.java.nodo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.nodo.dao.NhaXuatBanDAO;
import com.java.nodo.entities.NhaXuatBan;

@RestController
@RequestMapping("/nxb")
@CrossOrigin("http://localhost:4200")
public class NxbRestControllers {

    @Autowired
    private NhaXuatBanDAO nhaXuatBanDAO;

    @GetMapping
    public List<NhaXuatBan> ListNXB() {
        try {
            return this.nhaXuatBanDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    public NhaXuatBan add(@RequestBody NhaXuatBan nxb) {
        return this.nhaXuatBanDAO.insert(nxb);
    }

    @PutMapping("{id}")
    public NhaXuatBan update(@RequestBody NhaXuatBan nxb, @PathVariable Integer id) {
        return this.nhaXuatBanDAO.update(nxb);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Integer id) {
        return this.nhaXuatBanDAO.delete(id);
    }

}
