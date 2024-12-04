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

public class DoCheckAccountValid implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        AppLog.info(((ProcessContext) context).getRequest() + " " + this.getClass().getSimpleName());
        ProcessContext processContext = (ProcessContext) context;
        Result result = processContext.getResult();

        Request request = processContext.getRequest();
        Response response = processContext.getResponse();

        String code = request.getCode();

        if(CustDao.existAccount(code)){
            result = new SimpleResult("Account valid !", true, ResponseCode.SUCCESS);
        }else {
            result = new SimpleResult("Account not found !", false, ResponseCode.TRANSACTION_FAIL);
        }

        processContext.setResult(result);
        return !result.isOk();

    }
}
