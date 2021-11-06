package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.EdadAplicaEntity;

@Repository
public interface EdadAplicaRepository extends JpaRepository<EdadAplicaEntity, Integer> {

}
