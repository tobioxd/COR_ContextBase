package com.example.demo.bean.base;

import com.example.demo.bean.Cust;
import com.example.demo.bean.response.Result;
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

    public void putVar(String key, Object value){
        if(this.varRef.containsKey(key)){
            this.varRef.remove(key, value);
        }

        this.varRef.put(key, value);
    }

    public Object getVar(String key){
        return this.varRef.containsKey(key) ? this.varRef.get(key) : null;
    }
}
