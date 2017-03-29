package br.com.caelum.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaDeleta {
	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			
			Contato contato = new Contato();
			Long id;
			
			System.out.println("Insira o ID: ");
			id = teclado.nextLong();
			teclado.nextLine();
			
			ContatoDAO bd = new ContatoDAO();
			contato = bd.pesquisa(id);
			
			if (contato == null) {
				System.out.println("ID não encontrado.\n");
			}else{
				System.out.println("ID: " + contato.getId().toString());
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("Endereço: " + contato.getEndereco() + "\n\n");
								
				System.out.println("Tem certeza que deseja apagar? (S/N)");
				String opcao = teclado.next();
				if (opcao.equalsIgnoreCase("S")) {
					bd.remove(contato);
					System.out.println("Contato removido.");
				}else{
					System.out.println("Cancelado.");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
