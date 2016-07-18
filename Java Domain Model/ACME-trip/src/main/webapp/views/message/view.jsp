<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="message/respond.do" modelAttribute="messag">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	
	<form:label path="senderUser">
		<spring:message code="message.senderUser"/>:
	</form:label>
	<form:input path="senderUser.name" readonly="true"/>
	<form:errors cssClass="error" path="senderUser"/>
	<br/>
	
	<form:label path="subject">
		<spring:message code="message.subject"/>:
	</form:label>
	<form:input path="subject" readonly="true"/>
	<form:errors cssClass="error" path="subject"/>
	<br/>
	
	<form:label path="moment">
		<spring:message code="message.moment"/>:
	</form:label>
	<form:input path="moment" readonly="true"/>
	<form:errors cssClass="error" path="moment"/>
	<br/>
	
	<form:label path="priority">
		<spring:message code="message.priority"/>:
	</form:label>
	<form:input path="priority" readonly="true"/>
	<form:errors cssClass="error" path="priority"/>
	<br/>
	
	<form:label path="body">
		<spring:message code="message.body"/>:
	</form:label>
	<form:textarea path="body" readonly="true" rows="10" cols="40" />
	<form:errors cssClass="error" path="body"/>
	<br/>
	
	<input type="submit" name="save" value='<spring:message code="message.respond"/>'/>
	
	<input type="button" name="cancel"
		value="<spring:message code="message.cancel" />"
		onclick="javascript: window.location.replace('')" />
	<br />
	
	
	
</form:form>