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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.nodo.dao.TacGiaDAO;
import com.java.nodo.entities.TacGia;

@RestController
@RequestMapping("/tacgia")
@CrossOrigin("http://localhost:4200")
public class TacGiaRestController {

    @Autowired
    public TacGiaDAO tacGiaDAO;

    @GetMapping
    public List<TacGia> listTg() {
        return this.tacGiaDAO.getAll();
    }

    @PostMapping
    public TacGia insert(@RequestBody TacGia tg) {
        return this.tacGiaDAO.insert(tg);
    }

    @PutMapping("{id}")
    public TacGia update(@PathVariable("id") Integer id, @RequestBody TacGia tg) {
        tg.setId(id);
        return this.tacGiaDAO.update(tg);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.tacGiaDAO.delete(id);
    }
}
