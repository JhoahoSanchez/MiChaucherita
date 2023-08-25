package modelo.dao;

import java.util.List;

import modelo.entidades.Cuenta;

public interface CuentaDAO extends GenericDAO<Cuenta, Integer> {
	public Double total(List<Double> list);
}
