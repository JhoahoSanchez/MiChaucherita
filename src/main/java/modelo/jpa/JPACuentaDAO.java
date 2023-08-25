package modelo.jpa;

import java.util.List;

import modelo.dao.CuentaDAO;
import modelo.entidades.Cuenta;

public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO {

	public JPACuentaDAO() {
		super(Cuenta.class);
	}

	@Override
	public Double total(List<Double> list) {

		double sum = 0.0;
		for (Double saldo : list) {
			sum += saldo;
		}
		return sum;
	}

}
