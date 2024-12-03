package com.example.demo.service;

import com.example.demo.bean.ProcessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckProcess {
    private final DoCheckRefNo checkRefNo;
    private final CheckCustomerState checkCustomerState;
    private final DoCheckMsisdnEmail doCheckMsisdnEmail;
    private final CheckSRVCPCCDCustomer checkSRVCPCCDCustomer;

    @Autowired
    public CheckProcess(DoCheckRefNo checkRefNo,
                        CheckCustomerState checkCustomerState,
                        DoCheckMsisdnEmail doCheckMsisdnEmail,
                        CheckSRVCPCCDCustomer checkSRVCPCCDCustomer) {
        this.checkRefNo = checkRefNo;
        this.checkCustomerState = checkCustomerState;
        this.doCheckMsisdnEmail = doCheckMsisdnEmail;
        this.checkSRVCPCCDCustomer = checkSRVCPCCDCustomer;
    }

    public void executeProcess(ProcessContext processContext) {
        boolean checkResult;

        // Kiểm tra RefNo
        checkResult = checkRefNo.execute(processContext);
        if (!processContext.getResult().isOk()) return;

        // Kiểm tra trạng thái khách hàng
        checkResult = checkCustomerState.execute(processContext);
        if (!processContext.getResult().isOk()) return;

        // Kiểm tra Msisdn và Email
        checkResult = doCheckMsisdnEmail.execute(processContext);
        if (!processContext.getResult().isOk()) return;

        // Kiểm tra khách hàng SRVC PCCD
        checkResult = checkSRVCPCCDCustomer.execute(processContext);
        if (!processContext.getResult().isOk()) return;

        System.out.println("Tất cả các bước kiểm tra đã hoàn thành thành công.");
    }
}