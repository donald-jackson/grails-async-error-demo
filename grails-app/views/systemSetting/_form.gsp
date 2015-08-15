<%@ page import="co.centio.SystemSetting" %>



<div class="fieldcontain ${hasErrors(bean: systemSettingInstance, field: 'optionName', 'error')} required">
	<label for="optionName">
		<g:message code="systemSetting.optionName.label" default="Option Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="optionName" required="" value="${systemSettingInstance?.optionName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: systemSettingInstance, field: 'optionValue', 'error')} required">
	<label for="optionValue">
		<g:message code="systemSetting.optionValue.label" default="Option Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="optionValue" required="" value="${systemSettingInstance?.optionValue}"/>

</div>

