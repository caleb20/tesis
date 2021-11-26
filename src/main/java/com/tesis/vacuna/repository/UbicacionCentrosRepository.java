package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.UbicacionCentrosEntity;

@Repository
public interface UbicacionCentrosRepository extends JpaRepository<UbicacionCentrosEntity, Integer> {

}
