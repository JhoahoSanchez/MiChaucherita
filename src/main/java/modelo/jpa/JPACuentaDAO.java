package modelo.jpa;

import modelo.dao.CuentaDAO;
import modelo.entidades.Cuenta;

public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO{
	
	public JPACuentaDAO() {
		super(Cuenta.class);
	}
	
}
