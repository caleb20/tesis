package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.FrecuenciaEntity;

@Repository
public interface FrecuenciaRepository extends JpaRepository<FrecuenciaEntity, String> {

}
