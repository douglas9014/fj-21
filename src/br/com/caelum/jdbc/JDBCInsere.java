package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsere {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("insert into"
					+ " contatos(nome,email,endereco) values (?,?,?)");

			stmt.setString(1, "Caelum");
			stmt.setString(2, "contato@caelum.com.br");
			stmt.setString(3, "R. Vergueiro 3185 cj57");

			stmt.execute();
			stmt.close();
			
			System.out.println("Gravado!");
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
