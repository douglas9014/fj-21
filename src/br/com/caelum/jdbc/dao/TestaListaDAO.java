package br.com.caelum.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;

public class TestaListaDAO {
	public static void main(String[] args) throws SQLException {
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco() + "\n");
			}
	}
}
