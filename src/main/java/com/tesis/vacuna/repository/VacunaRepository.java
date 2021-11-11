package com.tesis.vacuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.VacunaEntity;

@Repository
public interface VacunaRepository extends JpaRepository<VacunaEntity, Integer> {

	List<VacunaEntity> findByIdEdadAplica(Integer idEdadAplica);

}
