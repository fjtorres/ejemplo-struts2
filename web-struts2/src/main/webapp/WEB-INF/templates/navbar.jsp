<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
	
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	        
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	        </button>
	
	        <s:a cssClass="navbar-brand" namespace="/" action="home"><s:text name="app.title" /> - <small>v<s:text name="app.version" /></small></s:a>
	
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	        <ul class="nav navbar-nav">
	            
	            <li class="dropdown <s:if test="%{isActiveNamespace('/person')}">active</s:if>">
	
	                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" onclick="return false;"><s:text name="menu.person" /> <span class="caret"></span></a>
	
	                <ul class="dropdown-menu" role="menu">
	                    <li <s:if test="%{isActiveMenu('list')}">class="active"</s:if>><s:a namespace="/person" action="list"><s:text name="menu.person.list" /></s:a></li>
	                    <li <s:if test="%{isActiveMenu('create')}">class="active"</s:if>><s:a namespace="/person" action="create"><s:text name="menu.person.create" /></s:a></li>
	                </ul>
	
	            </li>
	        </ul>
	    </div>
	
	</div>
</nav>