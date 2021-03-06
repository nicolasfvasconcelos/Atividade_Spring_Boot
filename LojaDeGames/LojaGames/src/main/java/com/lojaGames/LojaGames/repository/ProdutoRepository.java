package com.lojaGames.LojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaGames.LojaGames.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);// essa descricao vem da classe produto
	
}
