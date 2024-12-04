package com.example.demo.service;


import com.example.demo.command.DoCheckRefNo;
import com.example.demo.command.DoGetAccount;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class GetAccountByIdNo extends ChainBase {

    public GetAccountByIdNo() {
        super();
        addCommand(new DoCheckRefNo());
        addCommand(new DoGetAccount());
    }

}
