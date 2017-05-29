package dao;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {

	void adiciona(Produto produto);

	public List<Produto> getLista();

	void altera(Produto produto);

	void remove(Produto produto);
}
