package modelo.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dao.MovimientoDAO;
import modelo.entidades.Movimiento;

public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO {

	public JPAMovimientoDAO() {
		super(Movimiento.class);
	}

	@Override
	public List<Movimiento> getMovimientosByCategory(String categoria) {
	    String sentencia = "SELECT m FROM Movimiento m WHERE m.categoria.nombre = :categoria";
	    TypedQuery<Movimiento> query = em.createQuery(sentencia, Movimiento.class);
	    
	    query.setParameter("categoria", categoria);

	    List<Movimiento> filter = query.getResultList();
	    return filter;
	}

}
