package com.example.demo.service;

import com.example.demo.command.DoCheckRefNo;
import com.example.demo.command.DoGetAccount;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class GetAccountByIdNoService extends ChainBase {

    public GetAccountByIdNoService() {
        super();
        addCommand(new DoCheckRefNo());
        addCommand(new DoGetAccount());
    }

}
