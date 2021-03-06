package com.tesis.vacuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesis.vacuna.entity.ApoderadoHijoEntity;

public interface ApoderadoHijoRepository extends JpaRepository<ApoderadoHijoEntity, Integer> {

	List<ApoderadoHijoEntity> findByDniApoderado(String dniApoderado);

	List<ApoderadoHijoEntity> findByDniHijo(String dniHijo);

}
