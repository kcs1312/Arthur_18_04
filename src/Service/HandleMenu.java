package Service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;
import utils.GerenciadorProdutos;

public class HandleMenu {
	private Scanner Sc = new Scanner(System.in);
    private GerenciadorProdutos gp;
    private GerenciadorDeUsuarios Gu = new GerenciadorDeUsuarios();
    
    public HandleMenu(Scanner scanner) {
    	sc = scanner;
    	gp = new GerenciadorProdutos();
    	gu = new GerenciadorDeUsuarios();
    }
	Scanner sc = new Scanner(System.in);
	
	
	// Gerenciador 
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();


	private GerenciadorDeUsuarios gu;
	private int id;
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
		 
		 Usuario u = new Usuario(id, nome, senha); // Corrigido para passar o ID correto
	        gu.adicionarUsuario(u);
		
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
		List<Usuario> usuarios = gu.lerUsuarios();
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
		
		// buscar o unico no arquivo 
	}
	

    public void HandleMenu1() {
        sc = new Scanner(System.in);
        gp = new GerenciadorProdutos();
        gu = new GerenciadorDeUsuarios();
        // Inicialize todas as instâncias necessárias aqui
    }

    // Métodos existentes...

    public void somarPrecos() {
        System.out.println("Total dos preços dos produtos: " + gp.calcularTotalPreco());
    }

    public void contarProdutos() {
        System.out.println("Total de produtos: " + gp.contarProdutos());
    }

    public void trocarSenha() {
        System.out.println("Digite o ID do usuário:");
        int id = sc.nextInt();
        System.out.println("Digite a senha antiga:");
        String senhaAntiga = sc.next();
        System.out.println("Digite a nova senha:");
        String novaSenha = sc.next();
        ((GerenciadorDeUsuarios) gu).trocarSenha(id, senhaAntiga, novaSenha);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GerenciadorDeUsuarios getGu1() {
		return gu;
	}

	public void setGu1(GerenciadorDeUsuarios gu1) {
		this.gu = gu1;
	}

	public Scanner getSc() {
		return Sc;
	}

	public void setSc(Scanner sc) {
		Sc = sc;
	}

	public GerenciadorDeUsuarios getGu() {
		return Gu;
	}

	public void setGu(GerenciadorDeUsuarios gu) {
		Gu = gu;
	}
}


