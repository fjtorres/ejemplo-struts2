<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title><s:text name="app.title" /></title>
</head>
<body>
	<s:form namespace="/person" action="save" cssClass="form-horizontal">
		<div class="row">
			<s:hidden name="update" />
			<s:hidden name="model.id" />
			
			<div class="col-sm-6">
			
				<div class="form-group form-group-sm">
		            <label for="txtFirstName" class="control-label col-sm-3"><s:text name="field.firstName" /></label>
		            <div class="col-sm-9">
		                <s:textfield id="txtFirstName" name="model.firstName" maxlength="100" />
		            </div>
		        </div>
		        
   				<div class="form-group form-group-sm">
		            <label for="txtLastName" class="control-label col-sm-3"><s:text name="field.lastName" /></label>
		            <div class="col-sm-9">
		                <s:textfield id="txtLastName" name="model.lastName" maxlength="100" />
		            </div>
		        </div>
	        
	        </div>
	        
	        <div class="col-sm-6">
	        
		        <div class="form-group form-group-sm">
		            <label for="txtBirthday" class="control-label col-sm-3"><s:text name="field.birthday" /></label>
		            <div class="col-sm-9">
		                <s:textfield id="txtBirthday" name="model.birthday" />
		            </div>
		        </div>
		        
	        </div>
		</div>
	
		<div class="row">
	        <div class="col-sm-12">
	            <div class="btn-group pull-right">
	                <button type="submit" class="btn btn-success" title=""><s:text name="button.save" /></button>
	                <s:if test="%{!update}">
	                	<button type="reset" class="btn btn-primary" title=""><s:text name="button.clear" /></button>
	                </s:if>
					<s:a cssClass="btn btn-primary" action="list" namespace="/person"><s:text name="button.back" /></s:a>
	            </div>
	        </div>
	    </div>
	</s:form>
</body>
</html>