package com.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.entity.Produto;

public class ProdutoDAOTest {

	@Test
	public void testInserir() {
		boolean b;
		b = ProdutoDAO.inserir(null);
		Assert.assertFalse(b);
		b = ProdutoDAO.inserir(new Produto("Teste", "teste", 10));
		Assert.assertTrue(b);
		b = ProdutoDAO.inserir(new Produto(" ", null, 10));
		Assert.assertTrue(b);
		b = ProdutoDAO.inserir(new Produto(null, "teste", 10));
		Assert.assertTrue(b);	
	}
	@Test
	public void testSelect() {
		List<Produto> produto ;
		produto = ProdutoDAO.listAll();
		Assert.assertNotNull(produto);
	}
	@Test
	public void testAlterar() {
		boolean b;
		b = ProdutoDAO.alterar(null);
		Assert.assertFalse(b);
	}
	@Test
	public void testDeletar() {
		boolean b;
		b = ProdutoDAO.deletar(0);
		Assert.assertFalse(b);
	}
	
	
	
	
}
