package com.java.nodo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.nodo.entities.BanDoc;

@Repository
public interface BanDocRepository extends JpaRepository<BanDoc, Integer> {

}
