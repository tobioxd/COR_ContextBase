package com.example.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonDeserialize(
        as = SimpleResult.class
)

public class Result {

    protected boolean result;
    protected String message;
    protected String responseCode;

    public Result(){

    }

    public Result(boolean result, String message, String responseCode){
        this.result = result;
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isOk(){
        return this.result;
    }

    public String getResponseCode(){
        return this.responseCode;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this, new RecursiveToStringStyle());
    }

}
