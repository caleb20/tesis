package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.TipoPoblacionEntity;

@Repository
public interface TipoPoblacionRepository extends JpaRepository<TipoPoblacionEntity, String> {

}
