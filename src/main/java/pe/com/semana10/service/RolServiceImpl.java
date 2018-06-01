package pe.com.semana10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Genero;
import pe.com.semana10.repositorio.AdministradorRepositorio;
import pe.com.semana10.repositorio.AutorRepositorio;
import pe.com.semana10.repositorio.GeneroRepositorio;
import pe.com.semana10.repositorio.RolRepositorio;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepositorio repositorioInterface;
	
}
