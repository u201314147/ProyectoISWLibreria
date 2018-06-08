package pe.com.semana10.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import pe.com.semana10.model.Autor;

@Entity
@Table(name="libros")
@NamedQueries(
		{
			@NamedQuery(
					name="Libro.buscarPorPrecio",
					query="select r from Libro r where r.precio = ?1"
					),
			@NamedQuery(
					name="Libro.buscarPorGenero",
					query="select r from Libro r where r.genero.id = ?1"
					),
			@NamedQuery(
					name="Libro.buscarPorEditorial",
					query="select r from Libro r where r.editorial.id = ?1"
					)		
		})
		
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	Genero genero;
	//int genero_id;
	@ManyToOne(fetch=FetchType.LAZY)
	Editorial editorial;
	//int editorial_id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="libro_autor",
						joinColumns={@JoinColumn(name="libro_id")},
						inverseJoinColumns={@JoinColumn(name="autor_id")}
					  )
	private List<Autor> autores;
	
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	String titulo;
	
	double precio;
	
	String isbn;
	
	String sinopsis;
	int nuevo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public int getNuevo() {
		return nuevo;
	}
	public void setNuevo(int nuevo) {
		this.nuevo = nuevo;
	}

}
