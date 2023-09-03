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

import modelo.dao.UsuarioDAO;
import modelo.entidades.Credenciales;
import modelo.entidades.Usuario;
import modelo.jpa.JPAUsuarioDAO;

@Path("/usuario")
public class UsuarioRecurso {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
		return usuarioModelo.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuarioByPathParam(@PathParam("id") int id) {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
		return usuarioModelo.getById(id);
	}

	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuarioByQueryParam(@QueryParam("id") int id) {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
		return usuarioModelo.getById(id);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarUsuario(Usuario usuario) {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
		usuarioModelo.update(usuario);
	}
	
	@DELETE
	@Path("/delete")
	public void eliminarUsuario(@QueryParam("id") int id) {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
		usuarioModelo.deleteById(id);
	}

	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarUsuario(Usuario usuario) {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
		usuarioModelo.create(usuario);
	}
	
	@POST
	@Path("/autorizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario autorizar(Credenciales credenciales) {
		UsuarioDAO usuarioModelo = new JPAUsuarioDAO();
	    return usuarioModelo.autorizar(credenciales.getNombre(), credenciales.getClave());
	}	

}
