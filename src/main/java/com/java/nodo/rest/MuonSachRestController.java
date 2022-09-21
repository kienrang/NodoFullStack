package com.java.nodo.rest;

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

import com.java.nodo.dao.MuonSachDAO;
import com.java.nodo.entities.MuonSach;

import java.util.List;

@RestController
@RequestMapping("/muonsach")
@CrossOrigin("http://localhost:4200")
public class MuonSachRestController {

    @Autowired
    private MuonSachDAO muonSachDAO;

    @GetMapping
    public List<MuonSach> getAll() {
        return this.muonSachDAO.getAll();
    }

    @PostMapping
    public MuonSach insert(@RequestBody MuonSach ms) {
        return this.muonSachDAO.insert(ms);
    }

    @PutMapping("{id}")
    public MuonSach update(@PathVariable("id") Integer id, @RequestBody MuonSach ms) {
        ms.setId(id);
        return this.muonSachDAO.update(ms);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Integer id) {
        return this.muonSachDAO.delete(id);
    }
}
