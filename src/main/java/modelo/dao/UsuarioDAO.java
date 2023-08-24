package modelo.dao;

import java.util.List;

import modelo.entidades.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
	public Usuario autorizar(String nombre, String clave);
}
