<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitar criação do Museu</title>
</head>
<body>
	<h1>Sistema de gerenciamento de museu</h1>
	<h2>Solicitar criação do Museu</h2>
	<form action="criarMuseu" method="post">
		<div class="container">
			<label>Nome<br></label>
			<input type="text" placeholder="Digite o nome" name="nomeMuseu"/>
			<label>Data de criação<br></label>
			<input type="date" name="dataCriacao"/>
			<label>Cidade<br></label>
			<input type="text" placeholder="Digite a cidade" name="cidadeMuseu"/>
			<label>Estado<br></label>
			<input type="text" placeholder="Digite o Estado" name="estadoMuseu"/>
			<label><br>CPF do Gestor<br></label>
			<input type="text" placeholder="Digite o CPF" name="cpfGestor"/>
			<label><br>Senha<br></label> 
			<input type="password" placeholder="Digite a Senha" name="pswUsuario"/>
			<input type="submit" name="cmd" value="Solicitar criação"/>
		</div>
	
		
	</form>
</body>
</html>