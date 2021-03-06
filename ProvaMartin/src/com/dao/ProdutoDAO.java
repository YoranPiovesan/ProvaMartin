package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conexaoHSQLDB;
import com.entity.Produto;

public class ProdutoDAO extends conexaoHSQLDB {

	final static String SQL_INSERT_PRODUTO = "INSERT INTO PRODUTO(NOME, TIPO, PRECO) VALUES ( ?,?,?)";
	final static String SQL_SELECT_PRODUTO = "SELECT * FROM PRODUTO";
	final static String SQL_SELECT_PRODUTO_ID = "SELECT * FROM PRODUTO WHERE ID = ?";
	final static String SQL_ALTERA_PRODUTO = "UPDATE PRODUTO SET NOME=?, TIPO=?, PRECO=? WHERE ID = ?";
	final static String SQL_DELETA_PRODUTO = "DELETE FROM PRODUTO WHERE ID = ?";

	public  static boolean inserir(Produto produto) {
		int quantidade = 0;
		if(produto == null) {
			return false;
		}
		try (Connection connection = conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_INSERT_PRODUTO);) {
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getTipo());
			pst.setDouble(3, produto.getPreco());
			quantidade = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static List<Produto> listAll() {
		List<Produto> listaProduto = new ArrayList<Produto>();
		try (Connection connection = conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_PRODUTO);) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("ID"));
				produto.setNome(rs.getString("NOME"));
				produto.setTipo(rs.getString("TIPO"));
				produto.setPreco(rs.getFloat("PRECO"));
				listaProduto.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;
	}

	public static Produto findByID(int id) {
		Produto produto = null;
		try (Connection connection = conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_PRODUTO_ID);) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("ID"));
				produto.setNome(rs.getString("NOME"));
				produto.setTipo(rs.getString("TIPO"));
				produto.setPreco(rs.getFloat("PRECO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	public static boolean alterar(Produto produto) {
		int quantidade = 0;
		if(produto == null) {
			return false;
		}
		try (Connection connection = conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_PRODUTO);) {
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getTipo());
			pst.setDouble(3, produto.getPreco());
			pst.setInt(4, produto.getId());
			quantidade = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean deletar(int id) {
		if(id == 0) {
			return false;
		}
		int quantidade = 0;
		try (Connection connection = conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_DELETA_PRODUTO);) {
			pst.setInt(1, id);
			quantidade = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

}
