package com.example.demo.service;

import com.example.demo.command.DoCheckAccountExisted;
import com.example.demo.command.DoCheckRefNo;
import com.example.demo.command.DoCreateAccount;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService extends ChainBase {

    public CreateAccountService() {
        super();
        addCommand(new DoCheckRefNo());
        addCommand(new DoCheckAccountExisted());
        addCommand(new DoCreateAccount());
    }

}
