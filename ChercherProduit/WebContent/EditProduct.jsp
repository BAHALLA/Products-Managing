<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
	<p></p>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Edit Produit</div>
			<div class="panel-body">
			<form action="UpdateProduct" method="post">
			<div class="form-group">
					<label class="control-label">ID :</label>
					<input type="text" name="id" value="${produit.id}" class="form-control"/>
					<span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Designation :</label>
					<input type="text" name="designation" value="${produit.designation}" class="form-control"/>
					<span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Prix :</label>
					<input type="text" name="prix" value="${produit.prix }" class="form-control"/>
					<span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Quantite :</label>
					<input type="text" name="quantite" value="${produit.quantite }" class="form-control"/>
					<span></span>
				</div>
				<button type="submit" class="btn btn-primary">Update</button>
			</form>

			</div>
		</div>
	</div>
</body>
</html>