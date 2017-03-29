package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public Contato pesquisa(Long id) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from "
				+ "contatos where id=?");
		
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			
			return contato;
		}
		
		rs.close();
		stmt.close();
		
		return null;
		
	}

	public void adiciona(Contato contato) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("insert into "
				+ "contatos(nome,email,endereco) values(?,?,?)");

		stmt.setString(1,contato.getNome());
		stmt.setString(2,contato.getEmail());
		stmt.setString(3,contato.getEndereco());

		stmt.execute();
		stmt.close();
	}

	public List<Contato> getLista() throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
		ResultSet rs = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		
		while (rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			contatos.add(contato);
		}

		rs.close();
		stmt.close();
		return contatos;
	}

	public void altera(Contato contato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("update contatos set "
				+ "nome=?, email=?, endereco=? where id=?");
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setLong(4, contato.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Contato contato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
		stmt.setLong(1, contato.getId());
		stmt.execute();
		stmt.close();
		}

}