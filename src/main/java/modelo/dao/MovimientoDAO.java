package modelo.dao;

import java.util.List;

import modelo.entidades.Movimiento;

public interface MovimientoDAO extends GenericDAO<Movimiento, Integer> {
	
	List<Movimiento> getMovimientosByCategory(String categoria);
	
	public List<Movimiento> getMovimientosInRange(String from, String to);
}
