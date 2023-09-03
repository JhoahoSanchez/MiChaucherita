package modelo.serviciosrest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.dao.MovimientoDAO;
import modelo.entidades.Movimiento;
import modelo.jpa.JPAMovimientoDAO;

@Path("/movimiento")
public class MovimientoRecurso {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimiento> getMovimientos() {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		return movimientoModelo.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movimiento getMovimientoByPathParam(@PathParam("id") int id) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		return movimientoModelo.getById(id);
	}

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Movimiento getMovimientoByQueryParam(@QueryParam("id") int id) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		return movimientoModelo.getById(id);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarMovimiento(Movimiento movimiento) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		movimientoModelo.update(movimiento);
	}
	
	@DELETE
	@Path("/delete")
	public void eliminarMovimiento(@QueryParam("id") int id) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		movimientoModelo.deleteById(id);
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarMovimiento(Movimiento movimiento) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		movimientoModelo.create(movimiento);
	}
	
	@GET
	@Path("/searchByDates")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimiento> buscarMovimientosPorFecha(@QueryParam("fechaInicio") String fechaInicio, @QueryParam("fechaFin") String fechaFin) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		return movimientoModelo.getMovimientosInRange(fechaInicio, fechaFin);
	}
	
	@GET
	@Path("/searchByCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimiento> buscarMovimientosPorCategoria(@QueryParam("categoria") String categoria) {
		MovimientoDAO movimientoModelo = new JPAMovimientoDAO();
		return movimientoModelo.getMovimientosByCategory(categoria);
	}
	
}
