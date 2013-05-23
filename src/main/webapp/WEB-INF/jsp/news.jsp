<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Content-Language" content="fi"/> 
	
	<meta name="description" content="RSS feed esimerkki Kauppalehden uutisista."/> 
	<meta name="abstract" content="RSS feed esimerkki."/> 
	<meta name="keywords" content="RSS feed,esimerkki,kauppalehti"/> 
	
	<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>

	<script type="text/javascript" src="<c:url value="/js/jquery-1.8.2.min.js"/>"></script>

	<title>Uutiset</title>
</head>

<body>

<div class="content">

	<h1>Uutiset</h1>
	
	<div class="list">
		<c:forEach var="newsItem" items="${newsList}" varStatus="status">
			<div class="item">
				<div class="title">${newsItem.title}<span class="date">${newsItem.published}</span></div>
				<div class="description">${newsItem.description}</div>
				<a href="${newsItem.link}">Koko artikkeli...</a>
			</div>
			${not status.last ? '<div class="hrdiv"></div>' : ''}
		</c:forEach>
	</div>
	
</div>

</body>

</html>
