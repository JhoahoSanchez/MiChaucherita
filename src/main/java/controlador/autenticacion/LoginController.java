package controlador.autenticacion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ruta = (request.getParameter("ruta"))==null?"ingresar":request.getParameter("ruta");
		
		switch (ruta) {
		case "ingresar":
			this.verLogin(request,response);
			break;
		case "login":
			this.login(request,response);
			break;
		case "registrarUsuario":
			this.registrarUsuario(request, response);
			break;
		case "guardarUsuario":
			this.guardarUsuario(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + ruta);
		}
	}
	private void verLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("jsp/login.jsp");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {

	}

	private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) {

	}

	private void guardarUsuario(HttpServletRequest request, HttpServletResponse response) {

	}
}
