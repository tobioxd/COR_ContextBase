package com.example.demo.service;


import com.example.demo.command.DoCheckRefNo;
import com.example.demo.command.DoGetAccountByCode;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class GetAccountByCodeService extends ChainBase {

    public GetAccountByCodeService() {
        super();
        addCommand(new DoCheckRefNo());
        addCommand(new DoGetAccountByCode());
    }

}
