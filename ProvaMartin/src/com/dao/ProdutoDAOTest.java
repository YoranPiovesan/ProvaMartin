package com.dao;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.entity.Produto;

public class ProdutoDAOTest {

	@Test
	public void testInserir() {
		boolean b;
		b = ProdutoDAO.inserir(new Produto("Teste", "teste", 10));
		Assert.assertTrue(b);
		b = ProdutoDAO.inserir(new Produto("Teste", null, 10));
		Assert.assertTrue(b);
		b = ProdutoDAO.inserir(new Produto(null, "teste", 10));
		Assert.assertTrue(b);	
	}
	@Test
	public void testInserirNull() {
		boolean b;
		b = ProdutoDAO.inserir(null);
		Assert.assertFalse(b);
	}
	
	
	
	@Test
	public void testSelect() {
		List<Produto> produto ;
		produto = ProdutoDAO.listAll();
		Assert.assertNotNull(produto);
	}
	@Test
	public void testAlterar() {
		Produto produtoFirst = new Produto(99999, "velho", "teste", 10);
		Produto produtoSecond = new Produto(99999, "novo", "teste", 10);
		boolean b;
		ProdutoDAO.alterar(produtoFirst);
		System.out.println(produtoFirst);
		System.out.println(produtoSecond);
		System.out.println(produtoFirst);
		Assert.assertNotEquals(produtoFirst, produtoSecond);
		b =  ProdutoDAO.alterar(produtoFirst);
		Assert.assertTrue(b);

	}
	@Test
	public void testeAlterarNull() {
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
