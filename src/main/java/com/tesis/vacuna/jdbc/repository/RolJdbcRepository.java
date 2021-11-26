package com.tesis.vacuna.jdbc.repository;

import java.sql.SQLException;

public interface RolJdbcRepository {

	public void deleteRolByUsuario(Integer idUsuario) throws SQLException;

}
