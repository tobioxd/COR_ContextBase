package com.example.demo.service.test;

import com.example.demo.bean.base.ProcessContext;
import org.springframework.stereotype.Service;

@Service
public class CheckSRVCPCCDCustomer {
    public boolean execute(ProcessContext processContext) {
        // Logic kiểm tra khách hàng SRVC PCCD
        System.out.println("Đang kiểm tra khách hàng SRVC PCCD...");
        return processContext.getResult().isOk(); // Ví dụ đơn giản
    }
}