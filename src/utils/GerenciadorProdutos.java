package utils;

import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class GerenciadorProdutos {
	private List<Produto> produtos;
	private List<Produto> produto;
	private Produto[] produtos2;

    public GerenciadorProdutos() {
        this.setProdutos(new ArrayList<>());
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }
   	public double calcularTotalPreco() {
        double total = 0;
        produtos2 = null;
		for (Produto produto1 : produtos2) {
            total += produto1.getPreco();
        }
        return total;
    }

    public int contarProdutos() {
        produto = null;
		return produto.size();
    }
}
