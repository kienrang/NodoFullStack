package com.java.nodo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.nodo.entities.MuonSach;

@Repository
public interface MuonSachRepository extends JpaRepository<MuonSach, Integer> {

}
