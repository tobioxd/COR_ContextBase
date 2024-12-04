package com.example.demo.command;

import com.example.demo.bean.base.ProcessContext;
import com.example.demo.bean.response.Result;
import com.example.demo.bean.response.SimpleResult;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class DoCheckRefNo implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        ProcessContext processContext = (ProcessContext) context;
        Result result = SimpleResult.OK;
        processContext.setResult(result);
        return !result.isOk();
    }
}
