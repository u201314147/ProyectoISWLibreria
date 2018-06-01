package pe.com.semana10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Autor;
import pe.com.semana10.repositorio.AutorRepositorio;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepositorio repositorioInterface;
	
	@Override
	public List<Autor> listado() {
		List<Autor> autores = repositorioInterface.findAll();
		
		return autores;
	}

	
	//XYZ
	@Override
	public List<Autor> buscarPorNombre(String nombre) {
		return repositorioInterface.buscarPorNombre(nombre);
	}
	//XYZ
	
	@Override
	public boolean agregar(Autor autor) {
		// TODO Auto-generated method stub
		Autor objAutor = repositorioInterface.save(autor);
		if (objAutor == null){
			return false;
		}else{
			return true;
		}		
	}

	@Override
	public Autor buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorioInterface.findOne(id);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			repositorioInterface.delete(id);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean actualizar(Autor autor) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			repositorioInterface.save(autor);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return flag;
	}


}
