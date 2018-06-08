package pe.com.semana10.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="autores")

//XYZ
@NamedQueries(
		{
			@NamedQuery(
					name="Autor.buscarPorNombre",
					query="select r from Autor r where r.nombres = ?1"
					)
			})

//XYZ
public class Autor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//@Column(name="nombres")
	@NotEmpty(message="No puede estar vacío")
	private String nombres;
	@NotBlank(message="No puede estar en blanco")
	private String apellidos;
	//@NotEmpty(message="No puede estar vacío")
	@Size(min=4, max=100)
	private String nacionalidad;
	
	@ManyToMany(mappedBy="autores", fetch=FetchType.LAZY)
	List<Libro> libros;
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
