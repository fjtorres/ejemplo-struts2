package es.fjtorres.pruebas.juan.ejemplo.web.struts2.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespaces({ @Namespace("/") })
public class IndexAction extends ActionSupport {

    private static final long serialVersionUID = -3736810104548938783L;

    @Action(value = "home", results = { @Result(name = SUCCESS, location = "home.jsp") })
    public String home() {
        return SUCCESS;
    }
}
