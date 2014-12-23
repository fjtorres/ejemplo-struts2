<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title><s:text name="app.title" /></title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
		
			<div class="btn-toolbar" role="toolbar">
	            <div class="btn-group pull-right" role="group">
	                <s:a action="create" namespace="/person" cssClass="btn btn-default btn-sm" title="">
	                    <i class="glyphicon glyphicon-plus"></i>
	                </s:a>
	            </div>
	        </div>
		
			<table class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<th><s:text name="field.firstName" /></th>
						<th><s:text name="field.lastName" /></th>
						<th style="width: 170px;"><s:text name="field.birthday" /></th>
						<s:if test="%{!wrapper.items.isEmpty}">
							<th style="width: 90px;">&nbsp;</th>
						</s:if>
					</tr>
				</thead>
				<tbody>
					<s:if test="%{!wrapper.items.isEmpty}">
						<s:iterator  var="item" status="status" value="wrapper.items"> 
							<tr>
								<td><s:property value="%{#item.firstName}"/></td>
								<td><s:property value="%{#item.lastName}"/></td>
								<td>
									<s:text name="format.date">
										<s:param value="%{#item.birthday}"/>
									</s:text>
								</td>
								<td>
									<div class="text-center">
		                                <div class="btn-group">
		                                    <s:a namespace="/person" action="update" cssClass="btn btn-primary btn-xs" title="">
		                                    	<s:param name="selectedId" value="%{#item.id}"/>
		                                    	<i class="glyphicon glyphicon-edit"></i>
		                                    </s:a>
		                                    <a href="#" class="btn btn-danger btn-xs" title="" data-toggle="modal" data-target="personDeleteConfirm">
		                                    	<i class="glyphicon glyphicon-remove"></i>
		                                    </a>
		                                </div>
		                            </div>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
					</s:else>
					
				</tbody>
			</table>
			
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<s:a action="home" namespace="/"><s:text name="button.back" /></s:a>
		</div>
	</div>


	<div class="modal fade" id="personDeleteConfirm">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Modal title</h4>
				</div>
				<div class="modal-body">
					<p>One fine body&hellip;</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

</body>
</html>