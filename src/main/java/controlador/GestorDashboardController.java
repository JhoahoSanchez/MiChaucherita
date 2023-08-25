package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Categoria;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.TipoCategoria;
import modelo.entidades.TipoMovimiento;

@WebServlet("/GestorDashboardController")
public class GestorDashboardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Para cargar los datos en los combos
		List<Categoria> lista = DAOFactory.getFactory().getCategoriaDAO().getAll();
		List<String> incomeCategoryNames = new ArrayList<>();
		List<String> expenseCategoryNames = new ArrayList<>();
		List<String> transferCategoryNames = new ArrayList<>();

		for (Categoria categoria : lista) {
			if (categoria.getCategoria() == TipoCategoria.INGRESO) {
				incomeCategoryNames.add(categoria.getNombre());
			} else if (categoria.getCategoria() == TipoCategoria.EGRESO) {
				expenseCategoryNames.add(categoria.getNombre());
			} else {
				transferCategoryNames.add(categoria.getNombre());
			}
		}

		// Para cargar el saldo en las cuentas
		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAll();

		double saldoCash = 0.0;
		double saldoBank = 0.0;
		double saldoTrans = 0.0;
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getIdCuenta() == 1) {
				saldoCash = cuenta.getSaldo();
			} else if (cuenta.getIdCuenta() == 2) {
				saldoBank = cuenta.getSaldo();
			} else if (cuenta.getIdCuenta() == 3) {
				saldoTrans = cuenta.getSaldo();
			}
		}

		
		List<Movimiento> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAll();

		double totalIncome = 0.0;
		double totalExpense = 0.0;
		// Total income

		for (Movimiento movimiento2 : movimientos) {
			if (movimiento2.getTipoMovimiento().equals(TipoMovimiento.INGRESO)) {
				totalIncome += movimiento2.getValor();
			} else if (movimiento2.getTipoMovimiento().equals(TipoMovimiento.EGRESO)) {
				totalExpense += movimiento2.getValor();
			}
		}
		double totalBalance = totalIncome + totalExpense;

		request.setAttribute("incomeCategory", incomeCategoryNames);
		request.setAttribute("expenseCategory", expenseCategoryNames);
		request.setAttribute("transferCategoryNames", transferCategoryNames);

		request.setAttribute("accounts", cuentas);
		request.setAttribute("movimiento", movimientos);

		request.setAttribute("sumCash", saldoCash);
		request.setAttribute("sumBank", saldoBank);
		request.setAttribute("sumTrans", saldoTrans);

		request.setAttribute("totalIncome", totalIncome);
		request.setAttribute("totalExpense", totalExpense);
		request.setAttribute("totalBalance", totalBalance);

		request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
