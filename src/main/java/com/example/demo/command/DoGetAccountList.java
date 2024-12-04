package com.example.demo.command;

import com.example.demo.bean.Cust;
import com.example.demo.bean.base.ProcessContext;
import com.example.demo.bean.base.Request;
import com.example.demo.bean.base.Response;
import com.example.demo.bean.response.Result;
import com.example.demo.bean.response.SimpleResult;
import com.example.demo.bean.result.ResponseCode;
import com.example.demo.common.Constant;
import com.example.demo.common.VarRef;
import com.example.demo.dao.CustDao;
import com.example.demo.log.AppLog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import java.util.ArrayList;
import java.util.List;

public class DoGetAccountList implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        AppLog.info(((ProcessContext) context).getRequest() + " " + this.getClass().getSimpleName());
        ProcessContext processContext = (ProcessContext) context;
        Result result = SimpleResult.OK;
        Request request = processContext.getRequest();
        Response response = processContext.getResponse();

        int page = request.getPage();
        int limit = request.getLimit();

        List<Cust> custs = new ArrayList<>();

        try{
            custs = CustDao.getAccountsByPage(page, limit);

            if (!custs.isEmpty()) {
                result = new SimpleResult("Get Account list successfully", true, ResponseCode.SUCCESS);
            } else {
                result = new SimpleResult("No accounts found for the given page and limit", true, ResponseCode.SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new SimpleResult("Get Account failed", false, ResponseCode.TRANSACTION_FAIL);
        }

        response.setCusts(custs);
        processContext.setResponse(response);
        processContext.setResult(result);
        return !result.isOk();
    }
}
