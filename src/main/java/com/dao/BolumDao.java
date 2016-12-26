package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.model.Bolumu;

public interface BolumDao extends JpaRepository<Bolumu, Long> {

}
