<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
<title>Dashboard</title>
</head>
<body class="body">

	<header class="container-header">
		<h1>Chaucherita Finance</h1>
		<a class="icon" href="LoginController?ruta=salir"> <i
			class="fa-solid fa-right-from-bracket fa-2x"></i>
		</a>
	</header>

	<main class="container-main">
		<section class="container-main-1">
			<div class="container-img">
				<img src="images/profile.png" alt="">
			</div>
			<br>
			<c:if test="${not empty nombreUsuario}">
				<p style="text-align: center; font-size: 20px; font-weight: bold;">Hello
					${nombreUsuario}!</p>
			</c:if>

			<!-- Primera seccion OPCIONES -->
			<div class="container-main-1--1">
				<p style="font-weight: bold; font-size: 20px;">Quick Actions</p>
				<br>
				<div class="container-main-1--1--1 paneles">
					<a class="icon btn-abrir-popup" id="btn-abrir-popup1"> <i
						class="fa-solid fa-piggy-bank fa-2x" style="color: green;"></i>
						Income
					</a> <a class="icon btn-abrir-popup" href="#" id="btn-abrir-popup2">
						<i class="fa-solid fa-file-invoice-dollar fa-2x"
						style="color: red;"></i> Expense
					</a> <a class="icon btn-abrir-popup" href="#" id="btn-abrir-popup3">
						<i class="fa-solid fa-money-bill-transfer fa-2x"
						style="color: blue;"></i> Transfer
					</a>
				</div>
			</div>

			<!-- Segunda seccion  BALANCE TOTAL -->
			<br>
			<p style="font-weight: bold; font-size: 20px;">Accounts</p>
			<div class="container-main-1--2 paneles">
				<p>Cash</p>
				<p style="font-size: 40px; font-weight: bold; text-align: center;">$${sumCash}</p>
			</div>
			<div class="container-main-1--2 paneles">
				<p>Bank account</p>
				<p style="font-size: 40px; font-weight: bold; text-align: center;">$${sumBank}</p>
			</div>

			<div class="container-main-1--2 paneles" style="display: none;">
				<p>Transferencia</p>
				<p style="font-size: 40px; font-weight: bold; text-align: center;"
					name="transferAccount">$${sumTrans}</p>
			</div>
		</section>


		<!-- SECCION MAIN 2 -->
		<section class="container-main-2">
			<div class="container-wallet paneles">
				<div class="container-wallet-1">
					<p style="font-weight: bold; font-size: 20px;">My Wallet</p>
					<form action="GestorDashboardController?ruta=filterMoney" method="POST">
						<div class="col">
							<input type="month" name="fecha" id="fecha" class="calendario"
								value="2023-08" onchange="this.form.submit()">
						</div>
					</form>
				</div>
				<div class="container-wallet-2">
					<div class="card card-1">
						<p>Total Income</p>
						<h1>$${totalIncome}</h1>
					</div>
					<div class="card card-2">
						<p>Total Expense</p>
						<h1>$${totalExpense}</h1>

					</div>
					<div class="card card-3">
						<p>Total Balance</p>
						<h1>$${totalBalance}</h1>
					</div>
				</div>
			</div>


			<!-- TRANSACCTION HISTORY -->
			<div class="container-transaction paneles">

				<div class="container-transaction-1">
					<p style="font-weight: bold; font-size: 20px;">Transaction
						History</p>

					<form action="GestorDashboardController?ruta=filter" method="POST">
						<select name="categoriaFiltro" class="select"
							onchange="this.form.submit()">
							<option value="select">Todas las categorías</option>
							<c:forEach items="${listaCategoria}" var="lista">
								<option value="${lista}">${lista}</option>
							</c:forEach>
						</select>
					</form>
					
					<a class="icon btn-abrir-popup" href="#" id="btn-abrir-popup4">
						<i class="fa-solid fa-calendar"
						style="color: black;"></i> Filtrar por fecha
					</a>

					<form action="GestorDashboardController?ruta=inicio" method="get">
						<input type="hidden" name="ruta" value="inicio">
						<button type="submit" style="border: none;" class="icon">
							<i class="fa-solid fa-broom fa-2x"></i>
						</button>
					</form>
				</div>


				<c:choose>
					<c:when test="${not empty movcateg}">
						<c:set var="movimientos" value="${movcateg}" />
					</c:when>
					<c:otherwise>
						<c:set var="movimientos" value="${movimiento}" />
					</c:otherwise>
				</c:choose>

				<!-- Tabla de movimientos -->
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Amount</th>
							<th>Description</th>
							<th>Date</th>
							<th>Type</th>
							<th>Category</th>
							<th>Account</th>
						</tr>
					</thead>
					<c:forEach items="${movimientos}" var="movi" varStatus="status">
						<tr>
							<td>${movi.idMovimiento}</td>
							<td
								style="color: ${movi.tipoMovimiento == 'EGRESO' ? 'red' : (movi.tipoMovimiento == 'TRANSFERENCIA' ? 'blue' : 'green')}">
								${movi.tipoMovimiento == 'INGRESO' ? '+' : ''}$${movi.valor}</td>
							<td>${movi.descripcion}</td>
							<td>${movi.fecha}</td>
							<td>${movi.tipoMovimiento}</td>
							<td>${movi.categoria.nombre}</td>
							<td>${movi.cuenta.nombre}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>

	</main>

	<footer class="container-footer"> </footer>

	<!-- INCOME -->
	<div class="overlay" id="overlay">
		<div class="popup" id="popup">
			<a id="btn-cerrar-popup1" class="btn-cerrar-popup"><i
				class="fas fa-times"></i></a>
			<h3>Income</h3>

			<form action="GestorMovimientoController?ruta=income" class="form-1"
				method="POST">

				<div class="form-row">
					<label for="importe">Amount</label> <input type="number"
						id="importe" name="importe" placeholder="$10"
						style="color: green; font-weight: bold;" required>
				</div>


				<div class="form-row">
					<label for="fecha">Date</label> <input type="date" value="clear"
						name="fecha" id="fecha" required />
				</div>

				<div class="form-row">
					<label for="income-category">Income Category</label> <select
						id="income-category" name="income-category" class="short" required>
						<option value="select" selected>Select</option>
						<c:forEach items="${incomeCategory}" var="income">
							<option value="${income}">${income}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-row">
					<label for="cuenta">Account</label> <select id="tipo" name="cuenta"
						class="short" required>
						<option value="select" selected>select</option>
						<c:forEach items="${accounts}" var="account" varStatus="status">
							<c:if test="${!status.last}">
								<option value="${account.nombre}">${account.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

				<div class="form-row">
					<label for="concepto">Description</label> <input type="text"
						id="concepto" name="concepto" placeholder="Concepto">
				</div>

				<div class="form-row">
					<input type="submit" class="btn-submit" value="Save">
				</div>
			</form>
		</div>
	</div>
	
	
		<!-- DATE FILTER -->
	<div class="overlay" id="overlay4">
		<div class="popup" id="popup4">
			<a id="btn-cerrar-popup4" class="btn-cerrar-popup"><i
				class="fas fa-times"></i></a>
			<h3>DATE FILTER</h3>

			<form action="GestorDashboardController?ruta=date" class="form-1"
				method="POST">

				<div class="form-row">
					<label for="fechaIni">FROM</label> <input type="date" value="clear"
						name="fechaIni" id="fechaIni" required />
				</div>


				<div class="form-row">
					<label for="fechaFin">TO</label> <input type="date" value="clear"
						name="fechaFin" id="fechaFin" required />
				</div>

				<div class="form-row">
					<input type="submit" class="btn-submit" value="Save">
				</div>
			</form>
		</div>
	</div>

	<!-- EXPENSE -->

	<div class="overlay" id="overlay2">
		<div class="popup" id="popup2">
			<a href="#" id="btn-cerrar-popup2" class="btn-cerrar-popup"><i
				class="fas fa-times"></i></a>
			<h3>Expense</h3>

			<form action="GestorMovimientoController?ruta=expense" class="form-2"
				method="POST">

				<div class="form-row">
					<label for="importe">Amount</label> <input type="number"
						id="importe1" name="importe" placeholder="- $10"
						style="color: red; font-weight: bold;" required>
				</div>

				<div class="form-row">
					<label for="fecha">Date</label> <input type="date" value="clear"
						name="fecha" id="fecha" required />
				</div>


				<div class="form-row">
					<label for="expense-category">Expense Category</label> <select
						id="expense-category" name="expense-category" class="short"
						required>
						<option value="select" selected>Select</option>
						<c:forEach items="${expenseCategory}" var="expense">
							<option value="${expense}">${expense}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-row">
					<label for="cuenta">Account</label> <select id="tipo" name="cuenta"
						class="short" required>
						<option value="select" selected>select</option>
						<c:forEach items="${accounts}" var="account" varStatus="status">
							<c:if test="${!status.last}">
								<option value="${account.nombre}">${account.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

				<div class="form-row">
					<label for="concepto">Description</label> <input type="text"
						id="concepto" name="concepto" placeholder="Concepto">
				</div>

				<div class="form-row">
					<input type="submit" class="btn-submit" value="Save">
				</div>
			</form>
		</div>
	</div>

	<!-- TRANSFER -->
	<div class="overlay" id="overlay3">
		<div class="popup" id="popup3">
			<a href="#" id="btn-cerrar-popup3" class="btn-cerrar-popup"><i
				class="fas fa-times"></i></a>
			<h3>Transfer</h3>

			<form action="GestorMovimientoController?ruta=transfer"
				class="form-3" method="POST">

				<div class="form-row">
					<label for="importe">Amount</label> <input type="number"
						id="importe" name="importe" placeholder="$10"
						style="color: blue; font-weight: bold;" required>
				</div>

				<div class="form-row">
					<label for="fecha">Date</label> <input type="date" value="clear"
						name="fecha" id="fecha" required />
				</div>

				<div class="form-row">
					<label for="categoria">Source account</label> <select
						id="cuentaOrigen" name="cuentaOrigen" class="short" required>
						<option value="select" selected>select</option>
						<c:forEach items="${accounts}" var="account" varStatus="status">
							<c:if test="${!status.last}">
								<option value="${account.nombre}">${account.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>

				<div class="form-row">
					<label for="categoria">Destination account</label> <select
						id="cuentaDestino" name="cuentaDestino" class="short" required>
						<option value="select" selected>select</option>
						<c:forEach items="${accounts}" var="account" varStatus="status">
							<c:if test="${!status.last}">
								<option value="${account.nombre}">${account.nombre}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="form-row" style="display: none;">
					<label for="categoria">Category</label> <select
						id="transfer-category" name="transfer-category" class="short">
						<c:forEach items="${transferCategoryNames}" var="transfer">
							<option value="${transfer}">${transfer}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-row" style="display: none;">
					<label for="concepto">Description</label>
					<textarea id="concepto" name="concepto" placeholder="Nota"
						style="resize: none; border-radius: 15px; padding: 10px; border: 1px solid #ccc;"></textarea>
				</div>

				<div class="form-row">
					<input type="submit" class="btn-submit" value="Save">
				</div>
			</form>
		</div>
	</div>


	<script src="js/dashboard.js"></script>
	<script src="https://kit.fontawesome.com/db826525de.js"
		crossorigin="anonymous"></script>

	<script>
		
	</script>
</body>
</html>