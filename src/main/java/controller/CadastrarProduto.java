package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import dao.ProdutoJDBC;
import model.Produto;

@WebServlet("/cadastrar")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarProduto() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDAO produtoDao = new ProdutoJDBC();
		
		String descricao = request.getParameter("descricao");
		String valor = request.getParameter("valor");
		
		Produto novo = new Produto();
		novo.setDescricao(descricao);
		novo.setValor(Double.parseDouble(valor));
		
		produtoDao.adiciona(novo);
	}

}
