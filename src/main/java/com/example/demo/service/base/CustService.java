package com.example.demo.service.base;

import com.example.demo.bean.base.ProcessContext;
import com.example.demo.bean.base.Request;
import com.example.demo.bean.base.Response;
import com.example.demo.bean.response.*;
import com.example.demo.service.*;

public class CustService {

    public CustResponse getCustomerInfoById(Request request){
        ProcessContext context = new ProcessContext();
        context.setRequest(request);
        context.setResponse(new Response());
        GetAccountByIdNoService service = new GetAccountByIdNoService();
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
        GetAccountByCodeService service = new GetAccountByCodeService();
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

    public UpdateAccountResponse updateCustomer(Request request){
        ProcessContext context = new ProcessContext();
        context.setRequest(request);
        context.setResponse(new Response());
        UpdateAccountService service = new UpdateAccountService();
        try {
            service.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
            context.setResult(SimpleResult.UNKNOWN);
        }
        Result result = context.getResult();
        UpdateAccountResponse resp = new UpdateAccountResponse();
        resp.setRefNo(resp.getRefNo());
        resp.setResult(result);
        return resp;
    }

    public CustListResponse getCustomerList(Request request){
        ProcessContext context = new ProcessContext();
        context.setRequest(request);
        context.setResponse(new Response());
        GetAccountListService service = new GetAccountListService();
        try {
            service.execute(context);
        } catch (Exception e) {
            e.printStackTrace();
            context.setResult(SimpleResult.UNKNOWN);
        }
        Result result = context.getResult();
        Response response = context.getResponse();
        CustListResponse resp = new CustListResponse();
        resp.setRefNo(resp.getRefNo());
        resp.setResult(result);
        resp.setCusts(response.getCusts());
        return resp;
    }

}
