package com.java.nodo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.nodo.entities.NhaXuatBan;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan, Integer> {

}
