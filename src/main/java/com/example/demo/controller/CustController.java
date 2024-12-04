package com.example.demo.controller;

import com.example.demo.bean.base.BaseResponse;
import com.example.demo.bean.base.Request;
import com.example.demo.bean.base.Response;
import com.example.demo.bean.request.CreateAccountRequest;
import com.example.demo.bean.request.UpdateAccountRequest;
import com.example.demo.bean.response.CreateAccountResponse;
import com.example.demo.bean.response.CustResponse;
import com.example.demo.bean.response.SimpleResult;
import com.example.demo.bean.response.UpdateAccountResponse;
import com.example.demo.bean.result.ResponseCode;
import com.example.demo.service.base.CustService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CustController {

    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public CustResponse getbankAccountById(@RequestParam Long id) {

        CustResponse resp = new CustResponse();
        Request request = new Request();
        try{
            request.setId(id);
            CustService service = new CustService();
            resp = service.getCustomerInfoById(request);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult(new SimpleResult("Get Account failed", false, ResponseCode.UNKNOWN));
        }

        resp.setRefNo(resp.getRefNo());
        return resp;

    }

    @RequestMapping(value = "/get/code", method = RequestMethod.GET)
    public CustResponse getbankAccountByCode(@RequestParam String code) {

        CustResponse resp = new CustResponse();
        Request request = new Request();
        try{
            request.setCode(code);
            CustService service = new CustService();
            resp = service.getCustomerInfoByCode(request);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult(new SimpleResult("Get Account failed", false, ResponseCode.UNKNOWN));
        }

        resp.setRefNo(resp.getRefNo());
        return resp;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CreateAccountResponse createbankAccount(@RequestBody CreateAccountRequest param){
        CreateAccountResponse resp = new CreateAccountResponse();
        Request request = new Request();
        try{
            request.setBankcode(param.getBankcode());
            request.setCode(param.getCode());
            request.setName(param.getName());
            request.setRole("user");
            request.setUsername(param.getUsername());
            CustService service = new CustService();
            resp = service.createCustomer(request);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult(new SimpleResult("Create Account failed", false, ResponseCode.UNKNOWN));
        }

        resp.setRefNo(resp.getRefNo());
        return resp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public UpdateAccountResponse updatebankAccount(@RequestBody UpdateAccountRequest param){
        UpdateAccountResponse resp = new UpdateAccountResponse();
        Request request = new Request();
        try{
            request.setBankcode(param.getBankcode());
            request.setCode(param.getCode());
            request.setName(param.getName());
            CustService service = new CustService();
            resp = service.updateCustomer(request);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult(new SimpleResult("Update Account failed", false, ResponseCode.UNKNOWN));
        }

        resp.setRefNo(resp.getRefNo());
        return resp;
    }
}
