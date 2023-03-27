<%@page import="model.JavaBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="imagem/favicon.png">
<link rel="stylesheet" href="style.css">
<title>Sócios</title>

<% ArrayList<JavaBean> lista = (ArrayList<JavaBean>) request.getAttribute("contatos");%>
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="botaoInicio">Adicionar</a>
	<table>
		<thead>
			<tr>
				<th class='cabeca'>Id</th>
				<th class='cabeca'>Nome</th>
				<th class='cabeca'>Fone</th>
				<th class='cabeca'>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i  < lista.size(); i++){ %>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>