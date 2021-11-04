package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.NivelEducacionEntity;

@Repository
public interface NivelEducacionRepository extends JpaRepository<NivelEducacionEntity, String> {

}
