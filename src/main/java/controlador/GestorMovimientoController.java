package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("GestorMovimientoController")
public class GestorMovimientoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GestorMovimientoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void iniciar() {

	}

	private void crearTransferencia() {

	}

	private void guardarTransferencia(int idCuentaOr, int idCuentaDst, double valor, int descripcion, String fecha,
			int idCategoria) {

	}

	private void crearEgreso() {

	}

	private void guardarEgreso(int idCuentaDst, double valor, String descripcion, String fecha, int idCategoria) {

	}

	private void crearIngreso() {

	}

	private void guardarIngreso(int idCuentaDst, double valor, String descripcion, String fecha, int idCategoria) {

	}

}
