<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body class="body">
   <main class="container">
    <div class="container-1">
        <div class="container-1-1">
         <form action="../LoginController?ruta=login" method="POST" class="form">
             <fieldset>
                 <legend>Bienvenido :D!</legend><br>
                 <p>Inicia sesión con tu cuenta</p> <br><br>
                 <input type="text" name="user" class="input"  autocomplete="off" placeholder="Usuario" required/>
                 <br><br>
                 <input type="password" name="password" class="input"  autocomplete="off" placeholder="Password" required/>
                 <br><br> 
                 <input type="submit" value="Ingresar" class="button"/>
             </fieldset>
         </form>
        </div>
     </div>
     <div class="container-2">
         <img src="../images/login.png" alt="">
     </div>
   </main>
  	<%@include file= '../templates/footer.html'%>
</body>


</html>