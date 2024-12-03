package com.example.demo.bean;

import org.apache.commons.chain.impl.ContextBase;

import java.util.HashMap;

public class ProcessContext extends ContextBase {

    private static final long serialVersionUID = 1L;

    private Request request;
    private Response response;
    private Cust cust;
    private Result result;
    private HashMap<String, Object> varRef = new HashMap();

    public Request getRequest() {
        return request;
    }
    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Cust getCust() {
        return cust;
    }

    public void setCust(Cust cust) {
        this.cust = cust;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public HashMap<String, Object> getVarRef() {
        return varRef;
    }

    public void setVarRef(HashMap<String, Object> varRef) {
        this.varRef = varRef;
    }
}
