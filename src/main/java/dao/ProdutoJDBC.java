package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoJDBC implements ProdutoDAO {
	private Connection connection;

	public ProdutoJDBC() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void adiciona(Produto produto) {
		String sql = "INSERT INTO produto (descricao, valor) values (?,?)";

		try {
			PreparedStatement smt = this.connection.prepareStatement(sql);

			smt.setString(1, produto.getDescricao());
			smt.setDouble(2, produto.getValor());

			smt.execute();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Produto> getLista() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();

			PreparedStatement smt = this.connection.prepareStatement("select * from produto");

			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Produto prod = new Produto();
				prod.setId(rs.getInt("id"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setValor(rs.getDouble("valor"));

				produtos.add(prod);
			}

			rs.close();
			smt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void altera(Produto produto) {
		String sql = "UPDATE produto SET descricao = ?, valor = ? where id = ?";

		try {
			PreparedStatement smt = this.connection.prepareStatement(sql);
			smt.setString(1, produto.getDescricao());
			smt.setDouble(2, produto.getValor());

			smt.execute();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(Produto produto) {
		try {
			PreparedStatement smt = this.connection.prepareStatement("delete from produto where id = ?");
			smt.setInt(1, produto.getId());
			smt.execute();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
