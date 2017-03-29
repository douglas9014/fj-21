package br.com.caelum.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			Contato contato = new Contato();
		
			System.out.println("Nome: ");
			contato.setNome(teclado.nextLine());
			
			System.out.println("E-mail: ");
			contato.setEmail(teclado.nextLine());
			
			System.out.println("Endereço: ");
			contato.setEndereco(teclado.nextLine());

			ContatoDAO bd = new ContatoDAO();
			bd.adiciona(contato);
			
			System.out.println("Gravado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
