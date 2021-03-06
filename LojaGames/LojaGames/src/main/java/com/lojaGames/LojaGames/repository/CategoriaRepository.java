package com.lojaGames.LojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaGames.LojaGames.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByPersonagemContainingIgnoreCase(String personagem);
	public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
	
}