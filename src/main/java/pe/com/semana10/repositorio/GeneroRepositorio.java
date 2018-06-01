package pe.com.semana10.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Genero;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Integer> {

}
