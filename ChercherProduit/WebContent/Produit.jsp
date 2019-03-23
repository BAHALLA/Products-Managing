<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chercher Produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
	<p></p>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Chercher produits par mot cle</div>
			<div class="panel-body">
				<form action="chercher" method="get">
					<label>Mot Cle : </label><input type="text" name="mc" value="${module.mc}">
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<p></p>
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Designation</th>
						<th>Prix</th>
						<th>Quantite</th>
						<th>Supprimer</th>
						<th>Editer</th>
					</tr>
					<c:forEach items="${module.produits}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.designation}</td>
							<td>${p.prix }</td>
							<td>${p.quantite}</td>
							<td><a href="supprimer?id=${p.id}">supprimer</a></td>
							<td><a href="editer?id=${p.id}">editer</a></td>
						</tr>
					</c:forEach>
					
				</table>

			</div>
		</div>
	</div>
</body>
</html>