package Service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {
	
	Scanner sc = new Scanner(System.in);
	
	
	// Gerenciador 
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();
	// Construtor vazio
	public HandleMenu() {
		// toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificaECria("usuarios.txt");
	}
	
	public void criar() {
		System.out.println("Digite o nome:");
		String nome = sc.next();
		System.out.println("Digite a senha:");
		String senha = sc.next();
		
		int id = getNextId();
		
		Usuario u = new Usuario(1, nome, senha);
		gs.adicionarUsuario(u);
		
	}
	
	public void editar() {
		System.out.println("Digite o id do usuario:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite a nova senha:");
		String senha = sc.next();
		
		gs.editarUsuario(id,  nome,  senha);
	}
	
	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado:");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
		
	}
	
	public void listar() {
		gs.listarUsuarios();
	}
	
	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		// for => foreach
		// Unico usuario : Lista com todos 
		for(Usuario usuario : usuarios) {
			int id = usuario.getId();
			// 1
			if(id > maxId) {
				// logica para descobrir ultimo id
				maxId = id;
			}
		}
		// soma 1 + 0 o ultimo
		return maxId + 1;
	}
	
	public void buscarUnico() {
		System.out.println("Digite o ID da busca: ");
		int id = sc.nextInt();
		
		// buscar o unico no arquivo 
	}
}
