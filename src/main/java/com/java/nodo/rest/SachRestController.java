package com.java.nodo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.nodo.dao.SachDAO;
import com.java.nodo.entities.Sach;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sach")
@CrossOrigin("http://localhost:4200")
public class SachRestController {
    @Autowired
    private SachDAO sachDAO;

    @GetMapping
    public List<Sach> getAll() {
        return this.sachDAO.getAll();
    }

    @PostMapping
    public Sach insert(@RequestBody Sach s) {
        return this.sachDAO.insert(s);
    }

    @PutMapping("{id}")
    public Sach update(@PathVariable("id") Integer id, Sach s) {
        s.setId(id);
        return this.sachDAO.update(s);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        System.out.println(this.sachDAO.delete(id));
    }

}
