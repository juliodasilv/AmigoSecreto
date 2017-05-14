<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<c:forEach var="m" items="${membros}">
	<tr>
		<td>${m.nome}</td>
	</tr>
</c:forEach>