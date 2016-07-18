<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table name="trips" id="row" class="displaytag" pagesize="5"
	keepStatus="true" requestURI="${requestURI}">
	<%--<display:column>
		<security:authorize access="hasRole('ADMIN')">
			<a href="gym/edit.do?gymId=${row.id}"> <spring:message
					code="gym.edit" />
			</a>
			<a href="gym/edit.do?gymId=${row.id}"> <spring:message
					code="gym.delete" />
			</a>
		</security:authorize>

		<security:authorize access="hasRole('CUSTOMER')">
			<a href="payment/pay.do?gymId=${row.id}"> <spring:message
					code="gym.pay" />
			</a>
		</security:authorize>

	</display:column>--%>
	<%--
	<display:column>
		<a href="service/list.do?gymId=${row.id}"><spring:message
				code="gym.service" /></a>
	</display:column>
	--%>
	<%--
	<spring:message code="gym.numberBooking" var="numberBooking"/>
	<display:column title="${numberBooking }" sortable="true">
		<jstl:forEach items="${row.serviceOfGym}" var="serviceOfGym">
			<jstl:out value="${serviceOfGym.booking.size()}"/>
		</jstl:forEach>
	</display:column>
	--%>

	<spring:message code="trip.title" var="nameHeader" />
	<display:column property="title" title="${titleHeader}" sortable="true" />

	<spring:message code="trip.date" var="dateHeader" />
	<display:column property="date" title="${dateHeader}"
		sortable="false" />
		
	<spring:message code="trip.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}"
		sortable="false" />

	<spring:message code="trip.photo" var="photoHeader" />
	<display:column property="photo" title="${photoHeader}"
		sortable="false" />



</display:table>

<input type="text" value="" id="textSearch" />
<input type="button" id="buttonSearch"
	value="<spring:message code="trip.search"/>" />

<%--
<security:authorize access="hasRole('USER')">
	<div align=left>
		<a href="trip/create.do"><spring:message
				code="trip.create"></spring:message></a>
	</div>
</security:authorize>
--%>

<script type="text/javascript">
	$(document).ready(function(){
		$("#buttonSearch").click(function(){
			window.location.replace('trip/searchByKeyword.do?key=' + $("#textSearch").val());
		});
		
		$("#buttonSearch").onsubmit(function(){
			window.location.replace('trip/searchByKeyword.do?key=' + $("#textSearch").val());
		});
	});
</script>

