package com.example.demo.service;

import com.example.demo.command.DoCheckAccountExisted;
import com.example.demo.command.DoCheckAccountValid;
import com.example.demo.command.DoCheckRefNo;
import com.example.demo.command.DoUpdateAccount;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountService extends ChainBase {

    public UpdateAccountService() {
        super();
        addCommand(new DoCheckRefNo());
        addCommand(new DoCheckAccountValid());
        addCommand(new DoUpdateAccount());
    }

}
