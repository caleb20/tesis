package com.tesis.vacuna.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.enums.RolNombre;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}