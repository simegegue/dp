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

<display:table name="activities" id="row" class="displaytag" pagesize="5"
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
		<a href="activity/list.do?activityId=${row.id}"><spring:message
				code="activity.activityType" /></a>
	</display:column>
	--%>
	<%-- 
	<display:column property="activityType" title="${activityTypeHeader}" sortable="true">
	<a href="activity/list.do?activityId=${row.id}"><spring:message 
				code="activity.activityType" var="activityTypeHeader" /></a>
	</display:column>
	--%>
	
	<spring:message code="activity.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}" sortable="true" />
		
	<spring:message code="activity.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}"
		sortable="false" />

	<spring:message code="activity.photo" var="photoHeader" />
	<display:column property="photo" title="${photoHeader}"
		sortable="false" />
	
	<spring:message code="activity.type" var="typeHeader" />
	<display:column property="type.name" title="${typeHeader}"
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

