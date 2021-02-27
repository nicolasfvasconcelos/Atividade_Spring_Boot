package org.generation.blogPessoal.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

											//Primeira anotação
@Entity
											//Entidade do JPA
											//Segunda anotação
@Table (name = "postagem")
											//estou dizendo que essa entidade, dentro do BD, vai virar uma tabela
public class Postagem {
											//como será Id da postagem, precisamos configurar tbm
	@Id
											//o Id será gerado, então utilizo o generatedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
											//ou seja, esse atributo (id), com as anotações feitas, se tornará uma Primary Key
	private long id;
	
											// em titulo, falaremos quenão pode haver titulo vazio! então usaremos o NotNull
	@NotNull
	@Size(min = 5, max = 100) 				// Determina quantidade mínima e máxima de caracteres
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 500)
	private String texto;
											// assim que passar um dado, ele captura a hora, a data e o minuto dele
	
	@Temporal (TemporalType.TIMESTAMP) 		// como estamos trabalhando com data, o Temporal atua com tempo
	private Date date = new java.sql.Date(System.currentTimeMillis());
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	
	//Pronto, temos as classes criadas
	//Para que essa classe seja interpretada no BD como uma entidade, é necessário inserir algumas anotações
	//ANOTAÇÕES: parametros que colocamos dentro das classes ou identidades que definem certos tipos de comportamentos pra elas
}
