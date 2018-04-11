package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class AnagrammiDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public Set<String> getDizionario() {

		final String sql = "SELECT nome FROM parola";

		Set<String> parole = new HashSet<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				parole.add(rs.getString("nome"));
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return parole;
	}
	
	

}
