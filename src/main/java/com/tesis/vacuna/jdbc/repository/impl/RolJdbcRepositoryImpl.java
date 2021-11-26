package com.tesis.vacuna.jdbc.repository.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tesis.vacuna.jdbc.repository.RolJdbcRepository;

@Repository
public class RolJdbcRepositoryImpl implements RolJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void deleteRolByUsuario(Integer idUsuario) throws SQLException {

		StringBuilder query = new StringBuilder();
		query.append("DELETE FROM USUARIO_ROL ");
		query.append("WHERE USUARIO_ID = ? ");

		try {
			jdbcTemplate.update(query.toString(), idUsuario);
		} catch (Exception e) {

		} finally {
			jdbcTemplate.getDataSource().getConnection().close();
		}
	}

}
