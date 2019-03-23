<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Confirmation</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
	<p></p>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Confirmation</div>
			<div class="panel-body">
				<div class="form-group">
					<label>ID :</label>
					<label>${produit.id}</label>
				</div>
				<div class="form-group">
					<label>Designation :</label>
					<label>${produit.designation}</label>
				</div>
				<div class="form-group">
					<label>Prix :</label>
					<label>${produit.prix}</label>
				</div>
				<div class="form-group">
					<label>Quantite :</label>
					<label>${produit.quantite}</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>