package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;
public class GerenciadorDeUsuarios {
   private static final String NOME_ARQUIVO = null;
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
   
   public void adicionarUsuario(Usuario usuario) {
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
           bw.write(usuario.toString());
           bw.newLine();
           System.out.println("Usuário adicionado com sucesso!");
       } catch (IOException e) {
           System.out.println("Ocorreu um erro ao adicionar o usuário: " + e.getMessage());
       }
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
	    public void trocarSenha1(int id, String senhaAntiga, String novaSenha) {
	        List<Usuario> usuarios = lerUsuarios();
	        for (Usuario usuario : usuarios) {
	            if (usuario.getId() == id && usuario.getSenha().equals(senhaAntiga)) {
	                usuario.setSenha(novaSenha);
	                reescreverArquivo(usuarios);
	                System.out.println("Senha alterada com sucesso!");
	                return;
	            }
	        }
	        System.out.println("Usuário não encontrado ou senha antiga incorreta.");
	    }

		public void trocarSenha(int id, String senhaAntiga, String novaSenha) {
			
		}

		public void verificaECria(String string) {
			// TODO Auto-generated method stub
			
		}


		}
	 


 