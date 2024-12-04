package com.example.demo.service.base;

import com.example.demo.bean.base.ProcessContext;
import com.example.demo.bean.base.Request;
import com.example.demo.bean.base.Response;
import com.example.demo.bean.response.CreateAccountResponse;
import com.example.demo.bean.response.CustResponse;
import com.example.demo.bean.response.Result;
import com.example.demo.bean.response.SimpleResult;
import com.example.demo.service.GetAccountByCode;
import com.example.demo.service.GetAccountByIdNo;
import com.example.demo.service.CreateAccountService;

public class CustService {

    public CustResponse getCustomerInfoById(Request request){
        ProcessContext context = new ProcessContext();
        context.setRequest(request);
        context.setResponse(new Response());
        GetAccountByIdNo service = new GetAccountByIdNo();
        try {
            service.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
            context.setResult(SimpleResult.UNKNOWN);
        }
        Result result = context.getResult();
        Response response = context.getResponse();
        CustResponse resp = new CustResponse();
        resp.setRefNo(resp.getRefNo());
        resp.setResult(result);
        resp.setCust(response.getCust());
        return resp;
    }

    public CustResponse getCustomerInfoByCode(Request request){
        ProcessContext context = new ProcessContext();
        context.setRequest(request);
        context.setResponse(new Response());
        GetAccountByCode service = new GetAccountByCode();
        try {
            service.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
            context.setResult(SimpleResult.UNKNOWN);
        }
        Result result = context.getResult();
        Response response = context.getResponse();
        CustResponse resp = new CustResponse();
        resp.setRefNo(resp.getRefNo());
        resp.setResult(result);
        resp.setCust(response.getCust());
        return resp;
    }

    public CreateAccountResponse createCustomer(Request request){
        ProcessContext context = new ProcessContext();
        context.setRequest(request);
        context.setResponse(new Response());
        CreateAccountService service = new CreateAccountService();
        try {
            service.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
            context.setResult(SimpleResult.UNKNOWN);
        }
        Result result = context.getResult();
        CreateAccountResponse resp = new CreateAccountResponse();
        resp.setRefNo(resp.getRefNo());
        resp.setResult(result);
        return resp;
    }

}
