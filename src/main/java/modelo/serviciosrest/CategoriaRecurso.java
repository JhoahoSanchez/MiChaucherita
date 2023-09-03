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

import modelo.dao.CategoriaDAO;
import modelo.entidades.Categoria;
import modelo.jpa.JPACategoriaDAO;

@Path("/categoria")
public class CategoriaRecurso {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getCategorias() {
		CategoriaDAO categoriaModelo = new JPACategoriaDAO();
		return categoriaModelo.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria getCategoriaByPathParam(@PathParam("id") int id) {
		CategoriaDAO categoriaModelo = new JPACategoriaDAO();
		return categoriaModelo.getById(id);
	}

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria getCategoriaByQueryParam(@QueryParam("id") int id) {
		CategoriaDAO categoriaModelo = new JPACategoriaDAO();
		return categoriaModelo.getById(id);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarCategoria(Categoria categoria) {
		CategoriaDAO categoriaModelo = new JPACategoriaDAO();
		categoriaModelo.update(categoria);
	}
	
	@DELETE
	@Path("/delete")
	public void eliminarCategoria(@QueryParam("id") int id) {
		CategoriaDAO categoriaModelo = new JPACategoriaDAO();
		categoriaModelo.deleteById(id);
	}


	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarCategoria(Categoria categoria) {
		CategoriaDAO categoriaModelo = new JPACategoriaDAO();
		categoriaModelo.create(categoria);
	}

}
