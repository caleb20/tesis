package com.tesis.vacuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.ApoderadoEntity;

@Repository
public interface ApoderadoRepository extends JpaRepository<ApoderadoEntity, String> {

	List<ApoderadoEntity> findByHabilitado(Boolean habilitado);

}
