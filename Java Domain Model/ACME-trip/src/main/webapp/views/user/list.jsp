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

<display:table name="users" id="row" class="displaytag" pagesize="5"
	keepStatus="true" requestURI="${requestURI}">
	
	
	<display:column>
		<a href="trip/listRegisteredByUser.do?userId=${row.id}"><spring:message
				code="user.trip" /></a>
	</display:column>
	

	<spring:message code="user.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" 
		sortable="true" />

	<spring:message code="user.surnames" var="surnamesHeader" />
	<display:column property="surnames" title="${surnamesHeader}"
		sortable="true" />
		
	<spring:message code="user.email" var="emailHeader" />
	<display:column property="email" title="${emailHeader}"
		sortable="false" />

	<spring:message code="user.phone" var="phoneHeader" />
	<display:column property="phone" title="${phoneHeader}"
		sortable="false" />



</display:table>

<%--
<security:authorize access="hasRole('USER')">
	<div align=left>
		<a href="trip/create.do"><spring:message
				code="trip.create"></spring:message></a>
	</div>
</security:authorize>
--%>


