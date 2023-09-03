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

import modelo.dao.CuentaDAO;
import modelo.entidades.Cuenta;
import modelo.jpa.JPACuentaDAO;

@Path("/cuenta")
public class CuentaRecurso {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cuenta> getCuenta() {
		CuentaDAO cuentaModelo = new JPACuentaDAO();
		return cuentaModelo.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cuenta getCuentaByPathParam(@PathParam("id") int id) {
		CuentaDAO cuentaModelo = new JPACuentaDAO();
		return cuentaModelo.getById(id);
	}

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Cuenta getCuentaByQueryParam(@QueryParam("id") int id) {
		CuentaDAO cuentaModelo = new JPACuentaDAO();
		return cuentaModelo.getById(id);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarCuenta(Cuenta cuenta) {
		CuentaDAO cuentaModelo = new JPACuentaDAO();
		cuentaModelo.update(cuenta);
	}
	
	@DELETE
	@Path("/delete")
	public void eliminarCuenta(@QueryParam("id") int id) {
		CuentaDAO cuentaModelo = new JPACuentaDAO();
		cuentaModelo.deleteById(id);
	}

	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarCuenta(Cuenta cuenta) {
		CuentaDAO cuentaModelo = new JPACuentaDAO();
		cuentaModelo.create(cuenta);
	}
	
}
