
<%@ page import="co.centio.SystemSetting" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'systemSetting.label', default: 'SystemSetting')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-systemSetting" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-systemSetting" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list systemSetting">
			
				<g:if test="${systemSettingInstance?.optionName}">
				<li class="fieldcontain">
					<span id="optionName-label" class="property-label"><g:message code="systemSetting.optionName.label" default="Option Name" /></span>
					
						<span class="property-value" aria-labelledby="optionName-label"><g:fieldValue bean="${systemSettingInstance}" field="optionName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${systemSettingInstance?.optionValue}">
				<li class="fieldcontain">
					<span id="optionValue-label" class="property-label"><g:message code="systemSetting.optionValue.label" default="Option Value" /></span>
					
						<span class="property-value" aria-labelledby="optionValue-label"><g:fieldValue bean="${systemSettingInstance}" field="optionValue"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:systemSettingInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${systemSettingInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
