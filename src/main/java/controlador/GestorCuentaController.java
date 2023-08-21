package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GestorCuentaController")
public class GestorCuentaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GestorCuentaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void verMovimientos(int idCuenta) {

	}

	private void crearCuenta() {

	}

	private void guardarCuentaCreada(String nombre, String descripcion) {

	}

}
