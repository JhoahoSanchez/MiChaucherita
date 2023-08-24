package controlador.autenticacion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.entidades.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ruta = (request.getParameter("ruta"))==null?"verLogin":request.getParameter("ruta");
		
		switch (ruta) {
			case "verLogin":
				this.verLogin(request,response);
				break;
			case "login":
				this.login(request,response);
				break;
			case "salir":
				this.salir(request, response);
				break;
//			case "registrarUsuario":
//				this.registrarUsuario(request, response);
//				break;
//			case "guardarUsuario":
//				this.guardarUsuario(request, response);
//				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + ruta);
		}
	}
	private void salir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("jsp/login.jsp");
		
	}

	private void verLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("jsp/login.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1.- Obtener Datos	que me envian en la solicitud
				String nombre = request.getParameter("user");
				String clave = request.getParameter("password");
				//2.- Llamo al modelo  para obtener los datos (¿necesito lamar al modelo?)
				Usuario personaAutenticada = modelo.dao.DAOFactory.getFactory().getUsuarioDAO().autorizar(nombre, clave);
				System.out.println(personaAutenticada.toString());
				
				if(personaAutenticada != null) {
					
					//Creamos la sesion
					HttpSession session = request.getSession();
					session.setAttribute("Usuariologeado", personaAutenticada);
					
					// Almacenamos el nombre del usuario en la sesión
			        session.setAttribute("nombreUsuario", nombre);
			        response.sendRedirect("GestorDashboardController");
			        return;
				}else {
					String mensaje = "ingresaste mal el usuario y clave";
					request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				}
	}

//	private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {
//
//	}
//
//	private void guardarUsuario(HttpServletRequest request, HttpServletResponse response) {
//
//
//	}
}
