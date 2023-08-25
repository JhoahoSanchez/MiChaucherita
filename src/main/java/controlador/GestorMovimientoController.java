package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

@WebServlet("/GestorMovimientoController")
public class GestorMovimientoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GestorMovimientoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
		String nombre = request.getParameter("importe");
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = (request.getParameter("ruta")) == null ? "inicio" : request.getParameter("ruta");

		switch (ruta) {
		case "inicio":
			this.inicio(request, response);
			break;
		case "income":
			this.income(request, response);
			break;
		case "expense":
			this.expense(request, response);
			break;
		case "transfer":
			this.transfer(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + ruta);
		}
	}

	private void income(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiChaucherita");
		EntityManager em = emf.createEntityManager();

		Double amount = Double.parseDouble(request.getParameter("importe"));

		String fechaValue = request.getParameter("fecha");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		Date fecha = null;
//		try {
//		    fecha = dateFormat.parse(fechaValue);
//		} catch (ParseException e) {
//		    System.out.println("Hubo un problema en la conversion de tipos");
//		}

		String selectedIncomeCategory = request.getParameter("income-category");

		List<Categoria> lista = DAOFactory.getFactory().getCategoriaDAO().getAll();
		int x = 0;
		for (Categoria categoria : lista) {
			if (categoria.getNombre().equals(selectedIncomeCategory)) {
				x = categoria.getIdCategoria();
			}
		}
		Categoria incomeCategory = DAOFactory.getFactory().getCategoriaDAO().getById(x);

		String accountIncome = request.getParameter("cuenta");

		List<Cuenta> accounts = DAOFactory.getFactory().getCuentaDAO().getAll();
		int y = 0;
		for (Cuenta cuenta : accounts) {
			if (cuenta.getNombre().equals(accountIncome)) {
				y = cuenta.getIdCuenta();
			}
		}
		Cuenta account = DAOFactory.getFactory().getCuentaDAO().getById(y);

		String description = request.getParameter("concepto");

		Movimiento mov = new Movimiento();
		mov.setValor(amount);
		mov.setDescripcion(description);
		mov.setFecha(fechaValue);
		mov.setCuenta(account);
		mov.setCategoria(incomeCategory);
		mov.setTipoMovimiento(TipoMovimiento.INGRESO);
		DAOFactory.getFactory().getMovimientoDAO().create(mov);

		// Cuando doy al boton de guardar, los datos se guardan en la tabla de
		// movimientos
		// se actualizará el saldo en la cuenta
		double saldoSum = 0.0;
		if (account.getIdCuenta() == 1) {
			// si es cash
			Cuenta cashAccount = em.find(Cuenta.class, 1);
			saldoSum = cashAccount.getSaldo() + amount;
			cashAccount.setSaldo(saldoSum);
			em.getTransaction().begin();
			em.merge(cashAccount); // Actualizar la entidad en la base de datos
			em.getTransaction().commit();

		} else if (account.getIdCuenta() == 2) {
			// si es bank
			Cuenta bankAccount = em.find(Cuenta.class, 2);
			saldoSum = bankAccount.getSaldo() + amount;
			bankAccount.setSaldo(saldoSum);
			em.getTransaction().begin();
			em.merge(bankAccount);
			em.getTransaction().commit();
		}

		response.sendRedirect("GestorDashboardController");
	}

	private void expense(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiChaucherita");
		EntityManager em = emf.createEntityManager();

		Double amount = Double.parseDouble(request.getParameter("importe"));

		String fechaValue = request.getParameter("fecha");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		Date fecha = null;
//		try {
//		    fecha = dateFormat.parse(fechaValue);
//		} catch (ParseException e) {
//		    System.out.println("Hubo un problema en la conversion de tipos");
//		}

		String selectedIncomeCategory = request.getParameter("expense-category");

		List<Categoria> lista = DAOFactory.getFactory().getCategoriaDAO().getAll();
		int x = 0;
		for (Categoria categoria : lista) {
			if (categoria.getNombre().equals(selectedIncomeCategory)) {
				x = categoria.getIdCategoria();
			}
		}
		Categoria expenseCategory = DAOFactory.getFactory().getCategoriaDAO().getById(x);

		String accountExpense = request.getParameter("cuenta");

		List<Cuenta> accounts = DAOFactory.getFactory().getCuentaDAO().getAll();
		int y = 0;
		for (Cuenta cuenta : accounts) {
			if (cuenta.getNombre().equals(accountExpense)) {
				y = cuenta.getIdCuenta();
			}
		}
		Cuenta account = DAOFactory.getFactory().getCuentaDAO().getById(y);

		String description = request.getParameter("concepto");

		Movimiento mov = new Movimiento();
		mov.setValor(amount);
		mov.setDescripcion(description);
		mov.setFecha(fechaValue);
		mov.setCuenta(account);
		mov.setCategoria(expenseCategory);
		mov.setTipoMovimiento(TipoMovimiento.EGRESO);
		DAOFactory.getFactory().getMovimientoDAO().create(mov);

		double saldoSum = 0.0;
		if (account.getIdCuenta() == 1) {
			// si es cash
			Cuenta cashAccount = em.find(Cuenta.class, 1);
			saldoSum = cashAccount.getSaldo() + amount;
			cashAccount.setSaldo(saldoSum);
			em.getTransaction().begin();
			em.merge(cashAccount); // Actualizar la entidad en la base de datos
			em.getTransaction().commit();

		} else if (account.getIdCuenta() == 2) {
			// si es bank
			Cuenta bankAccount = em.find(Cuenta.class, 2);
			saldoSum = bankAccount.getSaldo() + amount;
			bankAccount.setSaldo(saldoSum);
			em.getTransaction().begin();
			em.merge(bankAccount);
			em.getTransaction().commit();
		}

		response.sendRedirect("GestorDashboardController");

	}

	private void transfer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiChaucherita");
		EntityManager em = emf.createEntityManager();
		Double amount = Double.parseDouble(request.getParameter("importe"));

		String fechaValue = request.getParameter("fecha");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		Date fecha = null;
//		try {
//		    fecha = dateFormat.parse(fechaValue);
//		} catch (ParseException e) {
//		    System.out.println("Hubo un problema en la conversion de tipos");
//		}

		// Cuenta 1
		String accountIncome = request.getParameter("cuentaOrigen");

		List<Cuenta> accounts = DAOFactory.getFactory().getCuentaDAO().getAll();
		int x = 0;
		for (Cuenta cuenta : accounts) {
			if (cuenta.getNombre().equals(accountIncome)) {
				x = cuenta.getIdCuenta();
			}
		}
		Cuenta sourceAccount = DAOFactory.getFactory().getCuentaDAO().getById(x);

		// cuenta 2
		String accountExpense = request.getParameter("cuentaDestino");

		int y = 0;
		for (Cuenta cuenta : accounts) {
			if (cuenta.getNombre().equals(accountExpense)) {
				y = cuenta.getIdCuenta();
			}
		}
		Cuenta destinationAccount = DAOFactory.getFactory().getCuentaDAO().getById(y);

		String selectedTransferCategory = request.getParameter("transfer-category");

		List<Categoria> lista = DAOFactory.getFactory().getCategoriaDAO().getAll();
		int w = 0;
		for (Categoria categoria : lista) {
			if (categoria.getNombre().equals(selectedTransferCategory)) {
				w = categoria.getIdCategoria();
			}
		}
		Categoria transferCategory = DAOFactory.getFactory().getCategoriaDAO().getById(w);
		Cuenta transfer = DAOFactory.getFactory().getCuentaDAO().getById(3);

		Movimiento mov = new Movimiento();
		mov.setValor(amount);
		mov.setDescripcion(sourceAccount.getNombre() + " -> " + destinationAccount.getNombre());
		mov.setFecha(fechaValue);
		mov.setCuenta(transfer);
		mov.setCategoria(transferCategory);
		mov.setTipoMovimiento(TipoMovimiento.TRANSFERENCIA);
		DAOFactory.getFactory().getMovimientoDAO().create(mov);

		Cuenta transferAccount = DAOFactory.getFactory().getCuentaDAO().getById(3);

		double saldoSum = 0.0;
		if (transferAccount.getIdCuenta() == 3) {
			// si es tranfer
			Cuenta transAccount = em.find(Cuenta.class, 3);
			saldoSum = transAccount.getSaldo() + amount;
			transAccount.setSaldo(saldoSum);
			em.getTransaction().begin();
			em.merge(transAccount); // Actualizar la entidad en la base de datos
			em.getTransaction().commit();

		}

		// Se le resta a la cuenta origen y se le suma a la cuenta destino
		// CuentaOrigen = CuentaOrigen - transfer
		// CuentaDestino = CuentaDestino + transfer
		// transfer = tranfer - transfer

		Double saldoSourceAccount = sourceAccount.getSaldo();
		Double saldoDestinationAccount = destinationAccount.getSaldo();
		Double saldoTransfer = transferAccount.getSaldo();

		System.out.println("Cuenta origen: " + sourceAccount.getNombre());
		saldoSourceAccount = saldoSourceAccount - amount;
		System.out.println("Saldo actualizado= " + saldoSourceAccount);

		System.out.println("Cuenta destino: " + destinationAccount.getNombre());
		saldoDestinationAccount = saldoDestinationAccount + amount;
		System.out.println("Saldo actualizado= " + saldoDestinationAccount);

		System.out.println("Cuenta transfer: " + transferAccount.getNombre());
		saldoTransfer = saldoTransfer - saldoTransfer;
		System.out.println("Saldo actualizado= " + saldoTransfer);

		sourceAccount.setSaldo(saldoSourceAccount);
		destinationAccount.setSaldo(saldoDestinationAccount);
		transferAccount.setSaldo(saldoTransfer);

		em.getTransaction().begin();
		em.merge(sourceAccount);
		em.merge(destinationAccount);
		em.merge(transferAccount);
		em.getTransaction().commit();
		response.sendRedirect("GestorDashboardController");

	}

	private void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("GestorDashboardController");
	}
//
//	private void crearTransferencia() {
//
//	}
//
//	private void guardarTransferencia(int idCuentaOr, int idCuentaDst, double valor, int descripcion, String fecha,
//			int idCategoria) {
//
//	}
//
//	private void crearEgreso() {
//
//	}
//
//	private void guardarEgreso(int idCuentaDst, double valor, String descripcion, String fecha, int idCategoria) {
//
//	}
//
//	private void crearIngreso() {
//
//	}
//
//	private void guardarIngreso(int idCuentaDst, double valor, String descripcion, String fecha, int idCategoria) {
//
//	}

}
