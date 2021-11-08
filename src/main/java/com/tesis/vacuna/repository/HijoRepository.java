package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.HijoEntity;

@Repository
public interface HijoRepository extends JpaRepository<HijoEntity, String> {
	
}
