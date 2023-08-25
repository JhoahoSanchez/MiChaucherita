package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario autorizar(String nombre, String clave) {
		String sentencia = "SELECT u FROM Usuario u WHERE u.username= :username AND u.password= :password";

		Query query = em.createQuery(sentencia);
		// Parametros ....
		query.setParameter("username", nombre);
		query.setParameter("password", clave);

		Usuario personaAutorizada = (Usuario) query.getSingleResult();
		return personaAutorizada;

	}

}
