package com.java.nodo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.nodo.entities.BanDoc;

@Repository
public interface BanDocRepository extends JpaRepository<BanDoc, Integer> {

    // @Query("select * from bandoc b WHERE b.ten like '%" + ":name" + "'%")
    // public List<BanDoc> getByName(@Param("name") String name);
}
