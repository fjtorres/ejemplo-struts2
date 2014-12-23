<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- Mensajes de error --%>
<s:if test="%{!actionErrors.isEmpty() || !fieldErrors.isEmpty()}">
	<div class="row">
		<div class="col-sm-12">
			<div class="alert alert-danger">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>
					<span class="sr-only">Close</span>
				</button>
				
				<s:actionerror/>
				<s:fielderror />

			</div>
		</div>
	</div>
</s:if>

<%-- Mensajes de información --%>
<s:if test="%{!actionMessages.isEmpty()}">
	<div class="row">
		<div class="col-sm-12">
			<div class="alert alert-info">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>
					<span class="sr-only">Close</span>
				</button>
				<s:actionmessage/>
			</div>
		</div>
	</div>
</s:if>