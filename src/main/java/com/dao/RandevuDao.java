package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.model.Muayene;
import com.model.Randevu;

public interface RandevuDao extends JpaRepository<Randevu, Long>{

}
