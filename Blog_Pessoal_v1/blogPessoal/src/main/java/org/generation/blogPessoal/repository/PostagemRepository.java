package org.generation.blogPessoal.repository;
							//repository: responsável pela comunicação com o banco de dados
import java.util.List;
import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
							//buscar todos pelo titulo que contém (tipo like do sql) (ignore case: ignorar se é maiusculo ou minusculo) e faz a busca do parametro entre parenteses

}
