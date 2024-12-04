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

public class DoGetAccount implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        AppLog.info(((ProcessContext) context).getRequest() + " " + this.getClass().getSimpleName());
        ProcessContext processContext = (ProcessContext) context;
        Result result = SimpleResult.OK;
        Request request = processContext.getRequest();
        Response response = processContext.getResponse();

        Long id = request.getId();

        Cust cust = null;

        try{
            cust = CustDao.getAccountById(id);
            processContext.putVar(VarRef.VAR_CUST_EXISTED_FLAG, Constant.CUSTOMER.CUST_FLAG_ID_USER_ID);

            if(cust != null){
                response.setCust(cust);
            }else {
                result = new SimpleResult("Account not found", false, ResponseCode.TRANSACTION_FAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new SimpleResult("Get Account failed", false, ResponseCode.TRANSACTION_FAIL);
        }

        processContext.setResponse(response);
        processContext.setResult(result);
        return !result.isOk();

    }
}
