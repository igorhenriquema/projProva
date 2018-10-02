package br.com.projProva.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projProva.entidade.Nomes;
import br.com.projProva.util.conexao;

public class nomesDB {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public nomesDB() {
		con = conexao.getConnection();
	}

	public boolean inserir (Nomes nomes) {
	
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO TB_prova (nome)");
			sb.append(" VALUES (?)");
		
			ps = this.con.prepareStatement(sb.toString());

		
			ps.setString(1, nomes.getNome());
			ps.execute();
		
			return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}catch(Exception e){
				e.printStackTrace();
		return false;
		}	
	}	
}
