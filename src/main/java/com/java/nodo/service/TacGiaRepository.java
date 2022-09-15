package com.java.nodo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.nodo.entities.TacGia;

@Repository
public interface TacGiaRepository extends JpaRepository<TacGia, Integer> {

}
