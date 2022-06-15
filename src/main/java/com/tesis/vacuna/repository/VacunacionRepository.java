package com.tesis.vacuna.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.entity.VacunacionEntity;

@Repository
public interface VacunacionRepository extends JpaRepository<VacunacionEntity, Integer> {

	List<VacunacionEntity> findByDniHijo(String dniHijo);

	VacunacionEntity findByDniHijoAndIdVacuna(String dniHijo, Integer idVacuna);

	List<VacunacionEntity> findByFechaCitaBetweenAndIdVacunaAndEstado(Date fechaIni, Date fechaFin, Integer idVacuna,
			String estado);

	List<VacunacionEntity> findByFechaCitaBetweenAndEstado(Date fechaIni, Date fechaFin, String estado);

	List<VacunacionEntity> findByFechaCitaBetweenAndIdVacunaAndEstadoAndIdUbicacion(Date fechaIni, Date fechaFin,
			Integer idVacuna, String estado, Integer idUbicacion);

	List<VacunacionEntity> findByFechaCitaBetweenAndEstadoAndIdUbicacion(Date fechaIni, Date fechaFin, String estado,
			Integer idUbicacion);
}
