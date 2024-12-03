package com.example.demo.service;

import com.example.demo.bean.ProcessContext;
import org.springframework.stereotype.Service;

@Service
public class DoCheckRefNo {
    public boolean execute(ProcessContext processContext) {
        // Logic kiểm tra RefNo
        System.out.println("Đang kiểm tra RefNo...");
        return processContext.getResult().isOk(); // Ví dụ đơn giản
    }
}
