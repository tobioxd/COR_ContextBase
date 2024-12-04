package com.example.demo.service;

import com.example.demo.command.DoCheckRefNo;
import com.example.demo.command.DoGetAccountList;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class GetAccountListService extends ChainBase {

    public GetAccountListService() {
        super();
        addCommand(new DoCheckRefNo());
        addCommand(new DoGetAccountList());
    }

}
