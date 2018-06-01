package pe.com.semana10.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.semana10.model.Administrador;
import pe.com.semana10.model.Autor;
import pe.com.semana10.model.Rol;
import pe.com.semana10.repositorio.AdministradorRepositorio;

@Service
public class AdministradorServiceImpl implements AdministradorService, UserDetailsService {

	@Autowired
	private AdministradorRepositorio repositorioInterface;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Administrador admin = repositorioInterface.buscarPorCorreo(correo);
		if(admin == null){
			return null;
		}else{
			List<GrantedAuthority> autorizaciones = obtenerRoles(admin.getRol());
			return usuarioAutenticacion(admin, autorizaciones);
		}
	}
	
	private List<GrantedAuthority> obtenerRoles(Rol rolesUsuario) {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(rolesUsuario.getNombre()));
		return roles;
	}
	
	private UserDetails usuarioAutenticacion(Administrador usuario, 
												List<GrantedAuthority> autorizaciones) {
		return 
			new 
				org.springframework.security.core.userdetails.User(
							usuario.getCorreo(), 
							usuario.getClave(),
							autorizaciones);
	
	}

	@Override
	public boolean guardar(Administrador objAdmin) {
		// TODO Auto-generated method stub
		Administrador objAdmin1 = repositorioInterface.save(objAdmin);
		if (objAdmin1 == null){
			return false;
		}else{
			return true;
		}	
	}
}
