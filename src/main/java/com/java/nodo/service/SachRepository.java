package com.java.nodo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.nodo.entities.Sach;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {

    // @Query("Select * form Sach s where s.ten like '%:ten%'")
    // public List<Sach> getByName(@Param("ten") String ten);
}
