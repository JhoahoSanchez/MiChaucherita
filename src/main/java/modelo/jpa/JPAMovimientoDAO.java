package modelo.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	@Override
	public List<Movimiento> getMovimientosInRange(String from, String to) {
		List<Movimiento> allMov = this.getAll();
		List<Movimiento> aux = new ArrayList<Movimiento>();
		try {
			Date Dfrom = new SimpleDateFormat("yyyy-MM-dd").parse(from);
			Date Dto = new SimpleDateFormat("yyyy-MM-dd").parse(to);
			Date mov = null;
			for (Movimiento movimiento : allMov) {
				mov = new SimpleDateFormat("yyyy-MM-dd").parse(movimiento.getFecha());
				if ((mov.before(Dto) && mov.after(Dfrom)) || mov.equals(Dfrom) || mov.equals(Dto)) {
					aux.add(movimiento);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aux;
	}

}
