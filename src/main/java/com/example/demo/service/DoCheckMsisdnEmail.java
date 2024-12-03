package com.example.demo.service;

import com.example.demo.bean.ProcessContext;
import org.springframework.stereotype.Service;

@Service
public class DoCheckMsisdnEmail {
    public boolean execute(ProcessContext processContext) {
        // Logic kiểm tra Msisdn và Email
        System.out.println("Đang kiểm tra Msisdn và Email...");
        return processContext.getResult().isOk(); // Ví dụ đơn giản
    }
}