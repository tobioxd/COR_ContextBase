package com.example.demo.command;

import com.example.demo.bean.base.ProcessContext;
import com.example.demo.bean.base.Request;
import com.example.demo.bean.base.Response;
import com.example.demo.bean.response.Result;
import com.example.demo.bean.response.SimpleResult;
import com.example.demo.bean.result.ResponseCode;
import com.example.demo.dao.CustDao;
import com.example.demo.log.AppLog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class DoCreateAccount implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        AppLog.info(((ProcessContext) context).getRequest() + " " + this.getClass().getSimpleName());
        Result result = SimpleResult.OK;
        ProcessContext processContext = (ProcessContext) context;
        Request request = processContext.getRequest();
        Response response = processContext.getResponse();

        String bankCode = request.getBankcode();
        String code = request.getCode();
        String name = request.getName();
        String role = request.getRole();
        String username = request.getUsername();

        try{
            boolean x = CustDao.insertAccount(bankCode, code, name, role, username);
            if(x == true){
                result = new SimpleResult("Create account successfully", true, ResponseCode.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new SimpleResult("GetAccount failed", false, ResponseCode.TRANSACTION_FAIL);
        }

        processContext.setResponse(response);
        processContext.setResult(result);
        return !result.isOk();
    }
}
