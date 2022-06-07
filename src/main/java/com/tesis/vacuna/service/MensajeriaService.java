package com.tesis.vacuna.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.VacunaDTO;
import com.tesis.vacuna.entity.VacunacionEntity;

@Service
public class MensajeriaService {

	@Autowired
	VacunacionService vacunacionService;

	@Autowired
	ApoderadoHijoService apoderadoHijoService;

	@Autowired
	FrecuenciaService frecuenciaService;

	@Autowired
	NivelRiesgoService nivelRiesgoService;

	public List<VacunaDTO> listadoPendientes() {

		List<VacunacionEntity> vacunacionEntities = vacunacionService.findAll();

		// ||

		for (VacunacionEntity vacunacionEntity : vacunacionEntities) {
			if (null == vacunacionEntity.getFecha() && null != vacunacionEntity.getFechaCita()) {

				List<ApoderadoDTO> apoderadoDTOs = apoderadoHijoService.findByDniHijo(vacunacionEntity.getDniHijo());

				for (ApoderadoDTO apoderadoDTO : apoderadoDTOs) {
					Integer intervalo = frecuenciaService
							.findById(nivelRiesgoService.findById(apoderadoDTO.getNivelRiesgo()).getFrecuencia())
							.getIntervalo();

					Date now = new Date();
					long diff = vacunacionEntity.getFechaCita().getTime() - now.getTime();
					TimeUnit time = TimeUnit.DAYS;
					Long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

					int resto = diffrence.intValue() % intervalo;

					if (resto == 0)
						System.out.println("envia");
					else
						System.out.println("no envia");

				}

			}
		}

		return null;
	}

}
