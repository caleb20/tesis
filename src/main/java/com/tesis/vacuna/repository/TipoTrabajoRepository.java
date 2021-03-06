package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.TipoTrabajoEntity;

@Repository
public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajoEntity, String> {

}
