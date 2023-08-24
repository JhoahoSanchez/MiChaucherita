<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css" />
    <title>Dashboard</title>
</head>
<body class="body">
    
    <header class="container-header">
        <h1>Chaucherita Finance</h1>
        <a class="icon" href="LoginController?ruta=salir" >
            <i class="fa-solid fa-right-from-bracket fa-2x"></i>
        </a>
    </header>

    <main class="container-main">
        <section class="container-main-1">
            <div class="container-img">
                <img src="images/profile.png" alt="">
            </div>
            <br>
             <c:if test="${not empty nombreUsuario}">
             	<p style="text-align: center; font-size: 20px; font-weight: bold;">Hello ${nombreUsuario}!</p>
            </c:if>
            
            <!-- Primera seccion OPCIONES -->
            <div class="container-main-1--1">
                <p style="font-weight: bold; font-size: 20px;">Quick Actions</p> <br>
                <div class="container-main-1--1--1 paneles">
                    <a class="icon btn-abrir-popup" href="#" id="btn-abrir-popup1">
                        <i class="fa-solid fa-piggy-bank fa-2x" style="color: green;"></i>
                        Income
                    </a>
                    
                    <a class="icon btn-abrir-popup" href="#" id="btn-abrir-popup2">
                        <i class="fa-solid fa-file-invoice-dollar fa-2x" style="color: red;"></i>
                        Expense
                    </a>
                    
                    <a class="icon btn-abrir-popup" href="#" id="btn-abrir-popup3">
                        <i class="fa-solid fa-money-bill-transfer fa-2x" style="color: blue;"></i>
                        Transfer
                    </a>
                </div>
            </div>

            <!-- Segunda seccion  BALANCE TOTAL -->
            <br><p style="font-weight: bold; font-size: 20px;">Accounts</p> 
            <div class="container-main-1--2 paneles">
                <p>Cash</p>
                <p style="font-size: 40px; font-weight: bold; text-align: center;">$670,000</p>
            </div>
            <div class="container-main-1--2 paneles">
                <p>Bank account</p>
                <p style="font-size: 40px; font-weight: bold; text-align: center;">$670,000</p>
            </div>
        </section>


        <!-- SECCION MAIN 2 -->
        <section class="container-main-2">
            <div class="container-wallet paneles">
                <div class="container-wallet-1">
                    <p style="font-weight: bold; font-size: 20px;">My Wallet</p>
                    <form action="" method="POST">
                        <div class="col">
                            <input type="month" name="fecha" id="fecha" class="calendario" value="2023-08">
                        </div>
                    </form>
                </div>
                <div class="container-wallet-2">
                    <div class="card card-1">
                    <p>Total Income</p>
                    <h1>$65,000</h1>
                    </div>
                    <div class="card card-2">
                    <p>Total Expense</p>
                    <h1>$65,000</h1>

                    </div>
                    <div class="card card-3">
                    <p>Total Balance</p>
                    <h1>$65,000</h1>
                    </div>
                </div>
            </div>
            

            <!-- TRANSACCTION HISTORY -->
            <div class="container-transaction paneles">

                <div class="container-transaction-1">
                    <p style="font-weight: bold; font-size: 20px;">Transaction History</p>
                    <p>Filter</p>
                </div>

                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Descripcion</th>
                            <th>Fecha</th>
                            <th>Tipo</th>
                            <th>Categoria</th>
                            <th>Cuenta</th>
                        </tr>
                    </thead>
                    <tr>
                        <td>1</td>
                        <td>Desc</td>
                        <td>12-2023</td>
                        <td>Gasto</td>
                        <td>Comida</td>
                        <td>Efectivo</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Desc</td>
                        <td>12-2023</td>
                        <td>Gasto</td>
                        <td>Comida</td>
                        <td>Efectivo</td>
                    </tr>                    
                    <tr>
                        <td>1</td>
                        <td>Desc</td>
                        <td>12-2023</td>
                        <td>Gasto</td>
                        <td>Comida</td>
                        <td>Efectivo</td>
                    </tr>
                </table>
            </div>
        </section>
       
    </main>

    <footer class="container-footer">

    </footer>

    <!-- INCOME -->
    <div class="overlay" id="overlay">
        <div class="popup" id="popup">
            <a href="#" id="btn-cerrar-popup1" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
            <h3>Income</h3>

            <form action="#" class="form-1" method="">

                <div class="form-row">
                    <label for="importe">Importe</label>
                    <input type="number" id="importe" name="importe" placeholder="$12000">
                </div>

                <div class="form-row">
                    <label for="categoria">Categoria</label>
                    <select id="categoria" name="categoria" class="short">
                        <option value="select" selected>select</option>
                        <option value="Salario">Salario</option>
                        <option value="Dinero Extra">Dinero Extra</option>
                        <option value="Plus">Plus</option>
                    </select>
                </div>

                <div class="form-row">
                    <label for="tipo">Tipo</label>
                    <select id="tipo" name="tipo" class="short">
                        <option value="select" selected>select</option>  
                        <option value="Dinero Efectivo">Dinero Efectivo</option>
                        <option value="Cuentas bancarias">Cuentas bancarias</option>
                    </select>
                </div>

                <div class="form-row">
                    <label for="concepto">Concepto</label>
                    <input type="text" id="concepto" name="concepto" placeholder="Concepto">
                </div>

                <div class="form-row">
                    <input type="submit" class="btn-submit" value="Guardar">
                </div>
            </form>
        </div>
    </div>

    <!-- EXPENSE -->

    <div class="overlay" id="overlay2">
        <div class="popup" id="popup2">
            <a href="#" id="btn-cerrar-popup2" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
            <h3>Expense</h3>

            <form action="#" class="form-2" method="">

                <div class="form-row">
                    <label for="importe">Importe</label>
                    <input type="number" id="importe" name="importe" placeholder="$12000">
                </div>

                <div class="form-row">
                    <label for="categoria">Categoria</label>
                    <select id="categoria" name="categoria" class="short">
                        <option value="select" selected>select</option>
                        <option value="Salario">Salario</option>
                        <option value="Dinero Extra">Dinero Extra</option>
                        <option value="Plus">Plus</option>
                    </select>
                </div>

                <div class="form-row">
                    <label for="tipo">Tipo</label>
                    <select id="tipo" name="tipo" class="short">
                        <option value="select" selected>select</option>  
                        <option value="Dinero Efectivo">Dinero Efectivo</option>
                        <option value="Cuentas bancarias">Cuentas bancarias</option>
                    </select>
                </div>

                <div class="form-row">
                    <label for="concepto">Concepto</label>
                    <input type="text" id="concepto" name="concepto" placeholder="Concepto">
                </div>

                <div class="form-row">
                    <input type="submit" class="btn-submit" value="Guardar">
                </div>
            </form>
        </div>
    </div>

        <!-- TRANSFER -->
        <div class="overlay" id="overlay3">
            <div class="popup" id="popup3">
                <a href="#" id="btn-cerrar-popup3" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
                <h3>Transfer</h3>
    
                <form action="#" class="form-3" method="">
    
                    <div class="form-row">
                        <label for="importe">Importe</label>
                        <input type="number" id="importe" name="importe" placeholder="$12000">
                    </div>
    
                    <div class="form-row">
                        <label for="categoria">Categoria</label>
                        <select id="categoria" name="categoria" class="short">
                            <option value="select" selected>select</option>
                            <option value="Salario">Salario</option>
                            <option value="Dinero Extra">Dinero Extra</option>
                            <option value="Plus">Plus</option>
                        </select>
                    </div>
    
                    <div class="form-row">
                        <label for="categoria">Cuenta Origen</label>
                        <select id="categoria" name="categoria" class="short">
                            <option value="select" selected>select</option>
                            <option value="Salario">Salario</option>
                            <option value="Dinero Extra">Dinero Extra</option>
                            <option value="Plus">Plus</option>
                        </select>
                    </div>

                    <div class="form-row">
                        <label for="categoria">Cuenta Destino</label>
                        <select id="categoria" name="categoria" class="short">
                            <option value="select" selected>select</option>
                            <option value="Salario">Salario</option>
                            <option value="Dinero Extra">Dinero Extra</option>
                            <option value="Plus">Plus</option>
                        </select>
                    </div>
    
                    <div class="form-row">
                        <label for="concepto">Concepto</label>
                        <input type="text" id="concepto" name="concepto" placeholder="Concepto">
                    </div>
    
                    <div class="form-row">
                        <input type="submit" class="btn-submit" value="Guardar">
                    </div>
                </form>
            </div>
        </div>
    
  
    <script src="js/dashboard.js"></script>
    <script src="https://kit.fontawesome.com/db826525de.js" crossorigin="anonymous"></script>
    
    
</body>
</html>