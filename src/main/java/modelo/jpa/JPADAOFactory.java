package modelo.jpa;

import modelo.dao.CategoriaDAO;
import modelo.dao.CuentaDAO;
import modelo.dao.DAOFactory;
import modelo.dao.MovimientoDAO;
import modelo.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new JPACategoriaDAO();
	}

	@Override
	public CuentaDAO getCuentaDAO() {
		return new JPACuentaDAO();
	}

	@Override
	public MovimientoDAO getMovimientoDAO() {
		return new JPAMovimientoDAO();
	}

}
