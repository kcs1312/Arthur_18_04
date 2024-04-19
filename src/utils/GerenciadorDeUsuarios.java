package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;
import models.Usuario;

public class GerenciadorDeUsuarios {
	private static final String NOME_ARQUIVO = "usuarios.txt";
	
	// Verificar a Existencia do nosso banco e criar caso nao exista
	public void verificaECria(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// verificar se o arquivo existe
		if(arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else {
			// tente criar. caso de erro, exibe o erro
			try {
			// Criar o novo arquivo	
			arquivo.createNewFile();
			System.out.println("Arquivo criado com sucesso!");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
		}
	  }
   }




   public void adicionarUsuario(Usuario usuario) {
	   // Writer => Escrever
	   // BuffereWriter , FileWriter
	   // BufferedWriter, proporciona uma eficiente escrita
	   // FileWriter, escreve dentro de arquivo+
	   try(BufferedWriter bw = new BufferedWriter( new FileWriter(NOME_ARQUIVO, true))) {
		   bw.write(usuario.toString()); // 1;arthur;12345
		   bw.newLine(); // nova linha no arquivo txt
		   System.out.println("Usuario adiconado com sucesso!");
	   } catch (IOException e) {
		   System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
	   }
     }
   
   public List<Usuario> lerUsuarios() {
	   List<Usuario> usuarios = new ArrayList<Usuario>();
	   // Buffed, File, Reader
	   try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
		   String linha; // linha => 1;nome;senha
		   // percorrer todas as linhas enquanto seja diferente de vazio
		   while((linha = br.readLine()) != null) {
			   String[] partes = linha.split(";"); // dividir em tres partes
			   usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
		   }
		   
	   } catch (IOException e) {
		   System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
	   }
	   return usuarios;
   }
   
   public void deletarUsuario(int id) {
	   List<Usuario> usuarios = lerUsuarios();
	   
	   if(usuarios.removeIf(usuario -> usuario.getId() == id)) {
		   // Reescrevendo arquivo com novos usuarios e alteracoes
		   reescreverArquivo(usuarios);
		   System.out.println("Usuario deletado com sucesso");
	   } else {
		   System.out.println("Usuario nao encontrado");
	   }
   }
   
   public void reescreverArquivo(List<Usuario> usuarios) {
	   try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
		   for(Usuario usuario : usuarios) {
			   bw.write(usuario.toString());
			   bw.newLine();
		   }
	   } catch (IOException e) {
		   System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
	   }
   }
   
   public void listarUsuarios() {
	   List<Usuario> usuarios = lerUsuarios();
	   // nenhum usuario
	   if(usuarios.isEmpty()) {
		   System.out.println("Nenhum usuario encontrado");
	   } else {
		   System.out.println("Lista de usuarios");
		   for (Usuario usuario : usuarios) {
			   System.out.println("ID: " + usuario.getId() + ", Nome: " + "" + usuario.getNome() + ", Senha: " + usuario.getSenha());
		   }
	   }
   }
   
   public void editarUsuario(int id, String novoNome, String novaSenha) {
	   List <Usuario> usuarios = lerUsuarios();
	   boolean encontrado = false;
	   
	   for (Usuario usuario : usuarios) {
		   if(usuario.getId() == id) {
			   usuario.setNome(novoNome);
			   usuario.setSenha(novaSenha);
			   encontrado = true;
			   break;
		   }
	   }
	   
	   if(encontrado) {
		   reescreverArquivo(usuarios);
		   System.out.println("Usuario editado com sucesso!");
	   } else {
		   System.out.println("Usuario nao encontrado");
	   }
   }
	    public void buscarUnico(int id) {
	    	List<Usuario> usuarios = lerUsuarios();
	    	
	    	for(Usuario usuario : usuarios) {
	    		if(usuario.getId() == id) {
	    			System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Senha: " + usuario.getSenha());
	    		}
	    	}
	    }

	    public static void main(String[] args) {
	        Produto produto1 = new Produto(1, "Camiseta", 129.99, 10);
	        Produto produto2 = new Produto(2, "Calça", 99.99, 5);

	        System.out.println("Informações do Produto 1:");
	        System.out.println("ID: " + produto1.getId());
	        System.out.println("Nome: " + produto1.getNome());
	        System.out.println("Preço: " + produto1.getPreco());
	        System.out.println("Quantidade: " + produto1.getQuantidade());
	        System.out.println("--------------------------");

	        System.out.println("Informações do Produto 2:");
	        System.out.println("ID: " + produto2.getId());
	        System.out.println("Nome: " + produto2.getNome());
	        System.out.println("Preço: " + produto2.getPreco());
	        System.out.println("Quantidade: " + produto2.getQuantidade());
	        System.out.println("--------------------------");

	        produto1.setPreco(25.99);
	        System.out.println("Novo preço da Camisa: " + produto1.getPreco());
	    }
	}

