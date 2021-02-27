package com.farmacia.farmacia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.farmacia.farmacia.model.produto;

public interface produtoRepository extends JpaRepository<produto, Long> {
	public List<produto> findAllByNomeContainingIgnoreCase (String nome);
}
