<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Login</h2>
	<form action="efetuarLogin" method="post">
	<div class="container">
		<label>CPF<br></label>
		<input type="text" placeholder="Digite o CPF" name="cpfUsuario"/>
		<label>Senha<br></label> 
		<input type="password" placeholder="Digite a Senha" name="pswUsuario"/>
		<input type="submit" name="cmd" value="Entrar"/>
	</div>
	<div class="container">
		<span><a href="CadastrarUsuario.jsp">Criar um novo usu�rio</a></span>
	</div>
		
	</form>
</body>
</html>