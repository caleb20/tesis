package com.tesis.vacuna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.NivelSocioEconomicoEntity;

@Repository
public interface NivelSocioEconomicoRepository extends JpaRepository<NivelSocioEconomicoEntity, String> {

}
