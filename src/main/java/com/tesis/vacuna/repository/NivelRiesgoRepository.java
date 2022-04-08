package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.NivelRiesgoEntity;

@Repository
public interface NivelRiesgoRepository extends JpaRepository<NivelRiesgoEntity, String> {

}
