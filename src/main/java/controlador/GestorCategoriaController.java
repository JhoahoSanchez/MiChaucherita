package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GestorCategoriaController")
public class GestorCategoriaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GestorCategoriaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Obtener datos que envian la solicitud

		// 2. LLamo al modelo para obtener los datos

		// 3. llamo a la vista

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Obtener datos que envian la solicitud

	}

	private void crearCategoria() {

	}

	private void guardarCategoria(String nombre) {

	}

}
