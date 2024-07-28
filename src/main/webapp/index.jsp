<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<h1>Welcome to Student ScholorShip Eligibility Service</h1>
		<div class="nav">
			<a href="upload.jsp">Upload CSV</a>
			<a href="#" onclick="showSearch()">Check Your Eligibility</a>
		</div>
		<div id="search-section" style="display: none;">
            <form onsubmit="return searchEligibility()" enctype="multipart/form-data">
                <input type="text" id="rollNumber" placeholder="Enter Roll Number">
                <button type="submit">Search</button>
            </form>
            <div id="searchResult"></div>
        </div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
