package ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ConnectionFactory;

public class CriaTabelaProdutos {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();

		String sql = "create table produto (id serial, descricao VARCHAR(255), valor real, primary key (id))";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.executeUpdate();
		c.close();
	}
}
