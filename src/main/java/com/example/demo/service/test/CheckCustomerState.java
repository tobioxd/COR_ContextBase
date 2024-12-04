package com.example.demo.service.test;

import com.example.demo.bean.base.ProcessContext;
import org.springframework.stereotype.Service;

@Service
public class CheckCustomerState {
    public boolean execute(ProcessContext processContext) {
        // Logic kiểm tra trạng thái khách hàng
        System.out.println("Đang kiểm tra trạng thái khách hàng...");
        return processContext.getResult().isOk(); // Ví dụ đơn giản
    }
}
