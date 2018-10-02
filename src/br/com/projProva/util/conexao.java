package br.com.projProva.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.corba.se.pept.transport.Connection;

public class conexao {
	public static java.sql.Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = null;
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdproblema", "root", "Ig090690@!");
			return (java.sql.Connection) con;
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace ();
			
		}
		return null;
	}
}
