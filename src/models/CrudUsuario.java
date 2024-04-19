package models;

public class CrudUsuario {
	  private String nome;
	    private String senha;

	    public void Usuario(String nome, String senha) {
	        this.nome = nome;
	        this.senha = senha;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
	}
