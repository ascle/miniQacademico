<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@ include file="css.jsp"%>
	<title></title>
</head>
<body>

<div id="fundo_topo"><!-- Pegar 100% do navegador -->
	<div id="topo"> <!-- Configurações da largura do topo e etc -->
		<div id="titulo_topo"><a href="home.action">Sistema Academico</a></div>			
	</div><!-- topo -->
</div> 	

<div>
	<p style="color: red"><s:property value="mensagemErro" /> </p>
	<p style="color: green"><s:property value="mensagemSucesso" /> </p>
</div>	
<div id="fundo_paginas">
	<div id="geral_paginas">
		<%@ include file="menu.jsp" %>
		<div id="conteudo">
	