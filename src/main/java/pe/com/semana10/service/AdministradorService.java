package pe.com.semana10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.semana10.model.Administrador;
import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Genero;

@Service
public interface AdministradorService {
	
	public boolean guardar(Administrador objAdmin);
	
}
