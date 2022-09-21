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

import com.java.nodo.dao.BanDocDAO;
import com.java.nodo.entities.BanDoc;

@RestController
@RequestMapping("/bandoc")
@CrossOrigin("http://localhost:4200")
public class BanDocRestController {
    @Autowired
    private BanDocDAO banDocDAO;

    @GetMapping
    public List<BanDoc> getAll() {
        return this.banDocDAO.getAll();
    }

    @PostMapping
    public BanDoc insert(@RequestBody BanDoc b) {
        return this.banDocDAO.insert(b);
    }

    @PutMapping("{id}")
    public BanDoc update(@RequestBody BanDoc b, @PathVariable("id") Integer id) {
        b.setId(id);
        return this.banDocDAO.update(b);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Integer id) {
        return this.banDocDAO.delete(id);
    }

    @GetMapping("{name}")
    public List<BanDoc> getByName(@PathVariable("name") String name) {
        return this.banDocDAO.getByName(name);
    }

}
