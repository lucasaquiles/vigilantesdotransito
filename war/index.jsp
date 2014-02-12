<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<style type="text/css">
	.row-fluid .content{
		padding:10px;
	}
	#main-wrapper{
		margin-top:20%;
	}
</style>
<head>

<%@include file="include/header.jsp"  %>

<title>Vigilantes do trânsito</title>
</head>
<body>
<!-- 	<div id="wrapper"> -->
    		
<!--     		<div id="welcome-wrapper"> -->
<!-- 	    		<h1>Que feio, Motorista!</h1> -->
<!-- 	    		<p>... let's starting!</p> -->
<!--     		</div> -->
<!--     </div> -->
	
	<div class="container">
		<div id="main-wrapper">
    	<div class="container-fluid">
		  <div class="row-fluid content">
		    <div class="span6 content" >
		      <h1>Sou novo aqui</h1>
		      <fieldset>
		      	<legend>Antes que você envie suas reclamações, precisamos saber que é você primeiro.</legend>
		      	
		      	<button class="btn btn-large btn-block" type="button">Entrar com o facebook</button>
				<button class="btn btn-large btn-block" type="button">Entrar com o twitter</button>
				<button class="btn btn-large btn-block" type="button">Entrar com sua conta do Google</button>
		      </fieldset>
		    </div>
		    <div class="span6 content" >
		      <h1>Buscar ocorrências</h1>
		      
		      <form>
			  <fieldset>
			    <legend>Procure por placa, região, tipo de ocorrência, etc.</legend>
			    <input type="text" placeholder="Placa. Ex: XXXXX">
			    <label>Tipo de ocorrência</label>
			    <select>
				  <option>Dono da rua</option>
				</select>
				<div>
			    <button type="submit" class="btn">Buscar</button>
			    </div>
			  </fieldset>
			</form>
		    </div>
		  </div>
		</div>
		</div>
  	</div>
</body>
</html>