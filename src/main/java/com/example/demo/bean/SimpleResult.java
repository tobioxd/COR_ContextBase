package com.example.demo.bean;

import com.sun.source.doctree.SummaryTree;

public class SimpleResult extends Result{

    public static final Result OK = new SimpleResult("ok", true, "00");
    public static final Result UNKNOWN = new SimpleResult("UNKNOWN", false, "GW99");
    public static final Result NULL = new SimpleResult("NULL", false, "GW-1");

    public SimpleResult(){

    }

    public SimpleResult(String message, boolean result, String responseCode){
        this.result = result;
        this.message = message;
        this.responseCode = responseCode;
    }

}
