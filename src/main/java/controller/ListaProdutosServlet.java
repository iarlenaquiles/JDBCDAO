package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import dao.ProdutoJDBC;
import model.Produto;

@WebServlet("/lista_produtos")
public class ListaProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaProdutosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDAO produtoDao = new ProdutoJDBC();
		List<Produto> produtos = produtoDao.getLista();
		request.setAttribute("produtos", produtos);
		request.getRequestDispatcher("lista_produtos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
