package com.tesis.vacuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.VacunacionEntity;

@Repository
public interface VacunacionRepository extends JpaRepository<VacunacionEntity, Long> {

	List<VacunacionEntity> findByDniHijo(String dniHijo);

	VacunacionEntity findByDniHijoAndIdVacuna(String dniHijo, Integer idVacuna);
}
