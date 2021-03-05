package org.generation.blogPessoal.controller;
											//Controller é responsável pela comunicação com o client(angular, postman, etc)
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
					
											//Primeiro precisamos colocar algumas anotações que indiquem que essa classe éum controller
@RestController 							//Indica que classe é um controller
@RequestMapping("/postagens") 				//Define qual será a URI que a classe será acessada
@CrossOrigin("*")							//essa classe aceita requisições de qualquer origem
public class PostagemController {
											//injetar a classe de repositorio nesse controller
	@Autowired 								//garante que todas as funções do Repositório sejam acessadas
	private PostagemRepository repositoty;

															//fazendo o metodo findAll
	@GetMapping("")				//rota de pesquisa			//indicando que esse metodo(abaixo) é Get
	private ResponseEntity<List<Postagem>> GetAll(){		//ResponseEntity --> resposta do HTTP //GetAll retorna tudo --> sem parametro específico
		return ResponseEntity.ok(repositoty.findAll()); 	//findAll é um metodo que retorna uma lista do tipo postagem até esse momento, se eu der GET no POSTMAN não terei retorno pq o banco de dados tá vazio! Inserir o dado no BD;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repositoty.findById(id)								//procurar por id
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repositoty.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(postagem));
	}
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(postagem));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoty.deleteById(id);
	}
	
}









