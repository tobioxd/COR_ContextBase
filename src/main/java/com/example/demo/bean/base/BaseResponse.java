package com.example.demo.bean.base;

import com.example.demo.bean.response.Result;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseResponse {

    private String refNo;
    private Result result;

    public BaseResponse(){

    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this, new RecursiveToStringStyle());
    }
}
