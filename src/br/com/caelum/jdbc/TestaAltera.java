package br.com.caelum.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {
	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			
			Contato contato = new Contato();
			Long id;
			
			System.out.println("Insira o ID: ");
			id = teclado.nextLong();
			
			ContatoDAO bd = new ContatoDAO();
			contato = bd.pesquisa(id);
			
			if (contato == null) {
				System.out.println("ID não encontrado.\n");
			}else{
				System.out.println("ID: " + contato.getId().toString());
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("Endereço: " + contato.getEndereco() + "\n\n");
				
				System.out.println("Insira os novos dados: \n");
				System.out.println("ID: ");
				contato.setId(teclado.nextLong());
				teclado.nextLine();
				
				System.out.println("Nome: ");
				contato.setNome(teclado.nextLine());
				System.out.println("E-mail: ");
				contato.setEmail(teclado.nextLine());
				System.out.println("Endereço: ");
				contato.setEndereco(teclado.nextLine());
								
				bd.altera(contato);
				System.out.println("Contato alterado. \n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
